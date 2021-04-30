package se.kth.iv1350.processSale.model;

import java.util.List;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.util.Amount;

/**
 * This class holds information about the ongoing sale
 *
 * @author Ali Sahibi
 */
public class SaleInformation {
    private List<Item> items;
    private Amount totalPrice;
    private Amount paymentAmount;
    
    /** 
     * Constructor for the class SaleInformation
     */
    public SaleInformation (){
        
    }
    
    /** 
     * Getter method for the total price of the sale
     * 
     * @return amount the total price
     */
    public Amount getTotalPrice (){
        return totalPrice;
    }
    
    /** 
     * This method adds the amount the costumer paid for the sale
     * 
     * @param paymentAmount amount of the payment
     */
    public void addpayment (Amount paymentAmount){
        this.paymentAmount = paymentAmount;
    }
    
    /**
     * This method calculates the change to give back to the costumer
     * 
     * @return the difference between amount paid and the total price
     */
    public Amount calculateChange (){
        return paymentAmount.subtract(totalPrice);
    }
}
