package se.kth.iv1350.processSale.model;

import java.util.List;
import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.CostumerRegistry;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.util.Percentage;

/**
 * This class is used to deal with discount related logic in the case of a
 * discount request during the sale
 *
 * @author Ali Sahibi
 */
public class Discount {
    private Sale sale;
    private CostumerDTO costumerDTO;
    private CostumerRegistry costumerRegistry;
    
    /** /
     * Constructor for the class Discount
     */
    public Discount (){
        
    }
    
    /** /
     * This method handles a discount request
     * 
     * @param costumerDTO the costumer is requesting a discount
     * @return percent discount 
     */
    public Percentage discountRequest (CostumerDTO costumerDTO, Sale sale){
        this.sale = sale;
        this.costumerDTO = costumerDTO;
        return calculateDiscount ();
    }
    
    public void getAccessToCostumerRegistry (IntegrationCreator integrations){
        this.costumerRegistry = integrations.getCostumerRegistry();
    }
    
    /** /
     * This method calculates the discount
     * 
     * @return percent discount 
     */
    private Percentage calculateDiscount (){
        Percentage calculatedDiscount = new Percentage (0);
        costumerRegistry.searchCostumer(costumerDTO);
        List<Item> itemsInSale = sale.getListOfItems();
        
        calculatedDiscount = costumerDTO.getBaseDiscountForCustomer().add(calculatedDiscount);
        calculatedDiscount = discountBasedOnNumberOfItems(itemsInSale, calculatedDiscount);
        calculatedDiscount = discountBasedOnTotalPrice(calculatedDiscount);
        
        return calculatedDiscount;
    }

    private Percentage discountBasedOnTotalPrice(Percentage calculatedDiscount) {
        if (sale.getTotalPrice().getValue() > 100 && sale.getTotalPrice().getValue() < 1000){
            calculatedDiscount = calculatedDiscount.add(new Percentage (2));
        }
        
        else if (sale.getTotalPrice().getValue() >= 1000){
            calculatedDiscount = calculatedDiscount.add(new Percentage (5));
        }
        return calculatedDiscount;
    }

    private Percentage discountBasedOnNumberOfItems(List<Item> itemsInSale, Percentage calculatedDiscount) {
        if (itemsInSale.size() > 1 && itemsInSale.size() < 10){
            calculatedDiscount = calculatedDiscount.add(new Percentage(5));
        }
        
        else if (itemsInSale.size() >= 10){
            calculatedDiscount = calculatedDiscount.add(new Percentage(10));
        }
        return calculatedDiscount;
    }
    
 
}
