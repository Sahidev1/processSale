package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.util.Amount;

/**
 * This is the class that handles the business logic
 * related to the sale
 * 
 * @author Ali Sahibi
 */
public class Sale {
    private SaleInformation saleInformation;
    
    /** /
     * Constructor method for the class Sale
     */
    public Sale (){
        
    }
    
    /** /
     * This method retrieves the current total price of the sale
     * 
     * @return amount the total price of the sale
     */
    public Amount getTotalPrice (){
        return saleInformation.getTotalPrice();
    }
    
    /**
     * This method handles discount requests
     * 
     * @param customerinformation a costumerDTO
     * @return an updated price based on the discount request
     */
    public Amount discountRequest (CostumerDTO customerinformation){
        
    }
    
    /**
     * This method initiates a payment for a sale
     * 
     * @param paymentAmount how much was paid for the sale
     * @return a Payment object holding information about the payment
     */
    public Payment makePayment (Amount paymentAmount){
        
    }
    
    /**
     * This method adds an item to the sale
     * 
     * @param foundItem the item to be added
     */
    public void addItemToSale (Item foundItem){
        
    }
    
    /**
     * This method adds a quantity of an item to the sale
     * 
     * @param foundItem them item to be added
     * @param quantity the quantity of the item to be added
     */
    public void addItemToSale (Item foundItem, int quantity){
        
    }
    
    /**
     * This method increments the quantity of an item already in the sale
     * 
     * @param foundItem the item to increment the quantity of
     */
    public void incrementQuantityOfAnItem (Item foundItem){
        
    }
    
}
