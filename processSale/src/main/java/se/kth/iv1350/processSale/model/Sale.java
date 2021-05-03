package se.kth.iv1350.processSale.model;

import java.util.List;
import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.util.Amount;
import se.kth.iv1350.processSale.util.Percentage;

/**
 * This is the class that handles the business logic
 * related to the sale
 * 
 * @author Ali Sahibi
 */
public class Sale {
    private SaleInformation saleInformation;
    private Payment payment;
    private Discount discount;

    
    /** 
     * Constructor method for the class Sale
     */
    public Sale (){
        this.saleInformation = new SaleInformation();
        this.payment = new Payment();
    }
    
    /** 
     * This method retrieves the current total price of the sale
     * 
     * @return amount the total price of the sale
     */
    public Amount getTotalPrice (){
        return saleInformation.getTotalPrice();
    }
    
    public List<Item> getListOfItems (){
        return saleInformation.getListOfItems();
    }
    
    /**
     * This method handles discount requests
     * 
     * @param customerinformation a costumerDTO
     * @return an updated price based on the discount request
     */
    public Amount discountRequest (CostumerDTO customerinfo, Discount discount){
        this.discount = discount;
        Percentage discountPercent = this.discount.discountRequest(customerinfo, this);
        return updatePriceBasedOnDiscount(discountPercent);
    }

    private Amount updatePriceBasedOnDiscount(Percentage discountPercent) {
        Amount updatedPrice = new Amount (100 - discountPercent.getPercentValue()).
        multiply(saleInformation.getTotalPrice());
        return updatedPrice;
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
        if (foundItem.getIsItemValid()){
            if (hasItemAlreadyBeenAdded (foundItem)){
                incrementQuantityOfItem (getItemFromTheList(foundItem));
            }
            
            else {
                saleInformation.addItem(foundItem);
            }
        }
    }
    
    /**
     * This method adds a quantity of an item to the sale
     * 
     * @param foundItem them item to be added
     * @param quantity the quantity of the item to be added
     */
    public void addItemToSale (Item foundItem, int quantity){
        if (foundItem.getIsItemValid()){
            if (hasItemAlreadyBeenAdded (foundItem)){
                updateQuantityOfItem (getItemFromTheList(foundItem), quantity);
            }
            
            else {
                foundItem.setQuantityOfItem(quantity);
                saleInformation.addItem(foundItem);
            }
        }   
    }
    
    /**
     * This method increments the quantity of an item already in the sale
     * 
     * @param foundItem the item to increment the quantity of
     */
    private void incrementQuantityOfItem (Item foundItem){
        saleInformation.incrementQuantityOfItem(foundItem);
    }
    
    /**
     * This method transfers the references to the Payment class
     * 
     * @param integrations an IntegrationsCreator
     * @param cashRegister a CashRegister
     */
    public void givePaymentParts (IntegrationCreator integrations,
    CashRegister cashRegister){
        payment.givePaymentParts (integrations, cashRegister);
    }
    
    public void giveAccessToCostumerRegistry (IntegrationCreator integrations){
        discount.getAccessToCostumerRegistry (integrations);
    }
    
    /**
     * This method checks whether an item has already been added to the list of
     * sale items
     * 
     * @param item the item to check
     * @return true if item already exists, else false
     */
    public boolean hasItemAlreadyBeenAdded (Item item){
        return saleInformation.hasItemAlreadyBeenAdded(item);
    }
    
    /**
     * This method retrieves the item in the list that is searched for
     * 
     * @param item that is to be retrieved
     * @return the found item, if no items is found it returns null
     */
    public Item getItemFromTheList (Item item){
        return saleInformation.searchForItem(item);
    }

    private void updateQuantityOfItem(Item foundItem, int addedQuantity) {
        saleInformation.updateQuantityOfItem(foundItem, addedQuantity);
    }
       
}
