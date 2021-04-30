package se.kth.iv1350.processSale.integration;

/**
 * This is the class responsible for making calls to the database to retrieve
 * information about an item
 *
 * @author Ali Sahibi
 */
public class ItemRegistry {
    
    /**
     * Constructor for the class ItemRegistry
     */
    public ItemRegistry (){
        
    }
    
    /** /
     * This method makes a call to the database to search for an item
     * if a match is found it returns a valid item, else it returns
     * an invalid Item with isItemValid field on the item set to false
     * 
     * @param itemDTO the item must match the itemDTO given as argument
     * @return item object is returned
     */
    public Item searchItem (ItemDTO itemDTO){
        
    }
    
    /** /
     * This method makes a call to the database to search for an item
     * if a match is found it returns a valid item, else it returns
     * an invalid Item with isItemValid field on the item set to false
     * 
     * @param itemDTO the item must match the itemDTO given as argument
     * @param quantity sets the quantity of the returned item
     * @return item object with a specific quantity is returned
     */
    public Item searchItem (ItemDTO itemDTO, int quantity){
        
    }
}
