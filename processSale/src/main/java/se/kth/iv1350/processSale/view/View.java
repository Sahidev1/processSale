package se.kth.iv1350.processSale.view;

import java.util.List;
import se.kth.iv1350.processSale.controller.Controller;
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
    
    /** /
     * Constructor for the class View
     * 
     * @param contr Controller object used as argument 
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    public void hardCodedCalls (){
        Sale currentSale = contr.newSale();
        System.out.println ("newSale() method called");
        
        String itemIdentifier = "AX531319";
        ItemDTO searchedItem = new ItemDTO (itemIdentifier);
        Item foundItem = contr.searchItem (searchedItem);
        System.out.println(foundItem.toString());
        currentSale.addItemToSale (foundItem);
        Amount totalcost = contr.getTotalPrice();
        System.out.println (totalcost);
        
    }
}
