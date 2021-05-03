package se.kth.iv1350.processSale.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.util.Amount;
import se.kth.iv1350.processSale.util.Percentage;

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

    public Amount getPaymentAmount() {
        return paymentAmount;
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
     * This method checks wether an item already is in the List of items
     * 
     * @param item is the item that is getting check
     * @return true if it is in the list, else false
     */
    public boolean hasItemAlreadyBeenAdded (Item item){
        for (Item itemInList : items){
            if (itemInList.equals(item)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method increment the quantity of an item
     * 
     * @param item to increment quantity of
     */
    public void incrementQuantityOfItem (Item item){
        item.incrementQuantityOfItem ();
        int quantity = 1;
        updateTotalPrice (item, quantity);
    }
    
    public void updateQuantityOfItem (Item item, int addedQuantity){
        item.updateQuantityOfItem (item, addedQuantity);
    }
    
    /** 
     * This method adds the amount the costumer paid for the sale
     * 
     * @param paymentAmount amount of the payment
     */
    public void addPayment (Amount paymentAmount){
        this.paymentAmount = paymentAmount;
    }
    
    /**
     * This method adds an item to the sale information
     * 
     * @param item the item to be added
     */
    public void addItem (Item item){
        items.add(item);
        int quantity =  item.getQuantity();
        updateTotalPrice (item, quantity);
    }
    
    /**
     * Updates the total price based on the discount for the costumer
     * 
     * @param discount the discount object with information about the discount
     */
    public void updateTotalPriceBasedOnDiscount (Discount discount){
        Percentage discountPercent = discount.getCalculatedDiscount();
        totalPrice = calculateTotalPriceBasedOnDiscount (discountPercent);
    }
    
    private Amount calculateTotalPriceBasedOnDiscount (Percentage discount){
        return new Amount (1.00 - (discount.getPercentValue() / 100)).
        multiply(totalPrice);
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
    private void updateTotalPrice (Item item, int quantity){
        totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));
    }
    
}
