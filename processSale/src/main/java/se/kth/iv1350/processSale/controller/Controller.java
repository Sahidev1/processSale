package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.model.Payment;
import se.kth.iv1350.processSale.util.Amount;

/**
 * The controller handles calls from the view to the other layers
 * 
 * @author Ali Sahibi
 */
public class Controller {
    private IntegrationCreator integrations;
    private Printer printer;
    
    /** /
     * Constructor for the Controller
     * 
     * @param integrations is an IntegrationsCreator object
     * @param printer is a Printer object
     */
    public Controller (IntegrationCreator integrations, Printer printer){
        this.integrations = integrations;
        this.printer = printer;  
    }
    
    /** /
     * This method starts a new sale
     */
    public void newSale(){
        
    }
    
    /** /
     * This method searches for an item in the database
     * 
     * @param searchedItem an itemDTO object
     * @return Item that was found in the database
     */
    public Item searchItem (ItemDTO searchedItem){
        
    }
    
    /** /
     * This method searches for an item in the the database
     * and also holds the quantity of the searched item
     * 
     * @param searchedItem an itemDTO object
     * @param quantity quantity of the itemDTO type searched
     * @return 
     */
    public Item searchItem (ItemDTO searchedItem, int quantity){
        
    }
    
    /** /
     * This method is used when there is a discount request
     * 
     * @param costumerDTO is a data of a costumers personal details
     * @return Amount the new price after the discount request
     */
    public Amount requestDiscount (CostumerDTO costumerDTO){
        
    }
    
    /** /
     * This method retrieves the total price of the Sale
     * 
     * @return total price of sale
     */
    public Amount getTotalPrice (){
        
    }
    
    /** /
     * This method is called to deal with the payment of sale
     * 
     * @param paymentAmount the amount to pay for the sale
     * @return a payment object which holds information about the payment
     */
    public Payment makePayment (Amount paymentAmount){
        
    }
}


