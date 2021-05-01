package se.kth.iv1350.processSale.model;

import java.util.ArrayList;
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
        this.items = new ArrayList<>();
        this.totalPrice = new Amount(0);
        this.paymentAmount = new Amount (0);
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
     * Getter method for the list of items
     * 
     * @return a reference to the list of items
     */
    public List<Item> getListOfItems (){
        return items;
    }
    
    /**
     * This method searches an item from List of items using the information
     * from another item outside of the list
     * 
     * @param item which contains item identifier
     * @return the found item if it is found, else null that nothing was found
     */
    public Item searchForItem (Item item){ 
        for (Item itemInList : items) {
            if (itemInList.equals(item)){
                return itemInList;
            }
        }
        return null;
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
     * This method adds an item to the sale information
     * 
     * @param item the item to be added
     */
    public void addItem (Item item){
        items.add(item);
        updateTotalPrice (item);
    }
    
    /**
     * This method calculates the change to give back to the costumer
     * 
     * @return the difference between amount paid and the total price
     */
    public Amount calculateChange (){
        return paymentAmount.subtract(totalPrice);
    }
    
    /**
     * This method updates the total price when an item has been added to
     * the sale
     * 
     * @param item that is added to the sale 
     */
    private void updateTotalPrice (Item item){
        totalPrice = totalPrice.add(item.getPrice());
    }
    
}
