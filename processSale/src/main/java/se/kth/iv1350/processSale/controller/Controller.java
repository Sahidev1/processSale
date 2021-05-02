package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.model.CashRegister;
import se.kth.iv1350.processSale.model.Payment;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.util.Amount;

/**
 * The controller handles calls from the view to the other layers
 * 
 * @author Ali Sahibi
 */
public class Controller {
    private IntegrationCreator integrations;
    private Printer printer;
    private CashRegister cashRegister;
    private Sale sale;

    
    /** 
     * Constructor for the Controller
     * 
     * @param integrations is an IntegrationsCreator object
     * @param printer is a Printer object
     */
    public Controller (IntegrationCreator integrations, Printer printer){
        this.integrations = integrations;
        this.printer = printer;  
        this.cashRegister = new CashRegister();
    }
    
    /** 
     * This method starts a new sale
     * 
     * @return a reference to the sale in controller
     */
    public Sale newSale(){
        this.sale = new Sale();
        sale.givePaymentParts (integrations, cashRegister);
        return this.sale;
    }
    
    /** 
     * This method searches for an item in the database
     * 
     * @param searchedItem an itemDTO object
     * @return Item that was found in the database
     */
    public Item searchItem (ItemDTO searchedItem){
        ItemRegistry itemReg = integrations.getItemRegistry ();
        Item foundItem = itemReg.searchItem(searchedItem);
        sale.addItemToSale(foundItem);
        
        if (foundItem.getIsItemValid()){
            if (sale.hasItemAlreadyBeenAdded(foundItem)){
                return sale.getItemFromTheList(foundItem);
            }
        }
        
        return foundItem;
    }
    
    /** 
     * This method searches for an item in the the database
     * and also holds the quantity of the searched item
     * 
     * @param searchedItem an itemDTO object
     * @param quantity quantity of the itemDTO type searched
     * @return item that was found in the database with the set quantity
     */
    public Item searchItem (ItemDTO searchedItem, int quantity){
        ItemRegistry itemReg = integrations.getItemRegistry ();
        Item foundItem = itemReg.searchItem(searchedItem, quantity);
        sale.addItemToSale(foundItem);
        
        if (foundItem.getIsItemValid()){
            if (sale.hasItemAlreadyBeenAdded(foundItem)){
                return sale.getItemFromTheList(foundItem);
            }
        }
        
        return foundItem;
    }
    
    /** 
     * This method is used when there is a discount request
     * 
     * @param costumerDTO is a data of a costumers personal details
     * @return Amount the new price after the discount request
     */
    public Amount requestDiscount (CostumerDTO costumerDTO){
        
    }
    
    /** 
     * This method retrieves the total price of the Sale
     * 
     * @return total price of sale
     */
    public Amount getTotalPrice (){
        return sale.getTotalPrice();
    }
    
    /** 
     * This method is called to deal with the payment of sale
     * 
     * @param paymentAmount the amount to pay for the sale
     * @return a payment object which holds information about the payment
     */
    public Payment makePayment (Amount paymentAmount){
        
    }
}


