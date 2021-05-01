package se.kth.iv1350.processSale.model;

import java.util.List;
import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
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
    private Payment payment;

    
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
        if (hasItemAlreadyBeenAdded (foundItem)){
            saleInformation.increment;
        }
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
    
    /**
     * This method transfers there references to the Payment class
     * 
     * @param integrations an IntegrationsCreator
     * @param cashRegister a CashRegister
     */
    public void givePaymentParts (IntegrationCreator integrations,
            CashRegister cashRegister){
        payment.givePaymentParts (integrations, cashRegister);
    }
    
    private boolean hasItemAlreadyBeenAdded (Item item){
        List <Item> listOfItems = saleInformation.getListOfItems();
        for (Item itemInTheList : listOfItems) {
            if (itemInTheList.equals(item)){
                return true;
            }
        }
        return false;
    }
    
    private Item getItemFromTheList (Item item){
        return saleInformation.searchForItem(item);
    }
    
    
    
}
