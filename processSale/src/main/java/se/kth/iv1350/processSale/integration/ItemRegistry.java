package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processSale.util.Amount;
import se.kth.iv1350.processSale.util.Percentage;

/**
 * This is the class responsible for making calls to the database to retrieve
 * information about an item
 *
 * @author Ali Sahibi
 */
public class ItemRegistry {
    private List<Item> itemData = new ArrayList<>();
    
    /**
     * Constructor for the class ItemRegistry
     */
    public ItemRegistry (){
        retrieveData ();
    }
    
    /** 
     * This method makes a call to the database to search for an item
     * if a match is found it returns a valid item, else it returns
     * an invalid Item with doesItMatch field on the item set to false
     * 
     * @param itemDTO the item must match the itemDTO given as argument
     * @return item object is returned
     */
    public Item searchItem (ItemDTO itemDTO){
        return searchItem (itemDTO, 1);
    }
    
    /** 
     * This method makes a call to the database to search for an item
     * if a match is found it returns a valid item, else it returns
     * an invalid Item with doesItMatch field on the item set to false
     * 
     * @param itemDTO the item must match the itemDTO given as argument
     * @param quantity sets the quantity of the returned item
     * @return item object with a specific quantity is returned
     */
    public Item searchItem (ItemDTO itemDTO, int quantity){
        String itemIdentifier = itemDTO.getItemIdentifier();
        Item foundItem;
        
        for (Item itemInRegistry : itemData) {
            if (doesItMatch(itemIdentifier, itemInRegistry)){
                foundItem = new Item(itemInRegistry);
                foundItem.setQuantityOfItem(quantity);
                return foundItem;
            }
        }
        
        foundItem = createInvalidItem();
        return foundItem;
    }
    
    /**
     * This method tests whether the searched for DTO has a matching
     * item identifier with an item in the database
     * 
     * @param itemIdentifier of the searched for DTO
     * @param item the Item to try the match with
     * @return true if it matches else false
     */
    private boolean doesItMatch (String itemIdentifier, Item item){
        return itemIdentifier.equals(item.getItemDTO().getItemIdentifier());
    }
    
    /**
     * This method creates an Item with doesItMatch field set to false
     * 
     * @return an invalid item
     */
    private Item createInvalidItem (){
        Item invalidItem = new Item ();
        invalidItem.setIsItemValid(false);
        return invalidItem;
    }
    
    /**
     * This method makes a call to the database and retrieves the data
     * and fills the itemData list with it
     * 
     * in this case we have created fake values that are read from a fake
     * database
     */
    private void retrieveData (){
        Amount priceOfItem0 = new Amount (22);
        Percentage VATofItem0 = new Percentage (6);
        ItemDTO itemDTO0 = new ItemDTO ("AX356235", "Apple", priceOfItem0, VATofItem0);
        Item apple = new Item (itemDTO0);
        itemData.add(apple);
        
        Amount priceOfItem1 = new Amount (34);
        Percentage VATofItem1 = new Percentage (12);
        ItemDTO itemDTO1 = new ItemDTO ("AX531319", "Sandwich", priceOfItem1, VATofItem1);
        Item sandwich = new Item (itemDTO1);
        itemData.add(sandwich);
        
        Amount priceOfItem2 = new Amount (56);
        Percentage VATofItem2 = new Percentage (25);
        ItemDTO itemDTO2 = new ItemDTO ("BX029510", "Pumpkin", priceOfItem2, VATofItem2);
        Item pumpkin = new Item (itemDTO2);
        itemData.add(pumpkin);
    }
}
