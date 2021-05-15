package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.util.Amount;

/**
 *  View is the programs user interface
 * 
 * @author Ali Sahibi
 */
public class View {
    private Controller contr;
    
    /** 
     * Constructor for the class View
     * 
     * @param contr Controller object used as argument 
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    public void hardCodedCalls (){
        contr.newSale();
        System.out.println ("newSale() method called" + "\n");
        
        String itemIdentifier = "AX531319";
        ItemDTO searchedItem = new ItemDTO (itemIdentifier);
        contr.searchItem (searchedItem);
        System.out.println ("Total cost: " + contr.getTotalPrice() + "\n");
        
        String identifierOfAlreadySearchedItem = "AX531319";
        ItemDTO alreadySearchedItem = new ItemDTO (identifierOfAlreadySearchedItem);
        contr.searchItem(alreadySearchedItem);
        System.out.println ("Total cost: " + contr.getTotalPrice() + "\n");  
        
        String itemIdentifierOfMultipleItems = "BX029510";
        int quantityOfItem = 7;
        ItemDTO searchMultipleOfItem = new ItemDTO (itemIdentifierOfMultipleItems);
        contr.searchItem(searchMultipleOfItem, quantityOfItem); 
        System.out.println("Total cost: " + contr.getTotalPrice() + "\n");
        
        String invalidItemIdentifier = "INVALIDIDENTIFIER000";
        ItemDTO searchedInvalidItem = new ItemDTO (invalidItemIdentifier);
        contr.searchItem (searchedInvalidItem);
        System.out.println ("Total cost: " + contr.getTotalPrice() + "\n");
        
        CostumerDTO costumerRequestingDiscount = new CostumerDTO ("John Doe",
        "19880509", "DoeTown evergreenstreet 22", "2391000102");
        Amount updatedPrice = contr.requestDiscount (costumerRequestingDiscount);
        System.out.println ("Discountrequest was made");
        System.out.println ("Total cost: " + updatedPrice + "\n");
        
        Amount paymentFromCostumer = new Amount (600);
        contr.makePayment(paymentFromCostumer);
    }   
}
