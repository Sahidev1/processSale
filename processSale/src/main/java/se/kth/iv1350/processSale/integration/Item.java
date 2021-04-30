package se.kth.iv1350.processSale.integration;

/**
 * This class represents the item object which is handled during the sale
 * 
 * @author Ali Sahibi
 */
public class Item {
    private int quantity;
    private boolean isItemValid;
    private ItemDTO itemDTO;
    
    /** /
     * Constructor for an Item object
     * 
     * @param itemDTO with immutable information about the item
     */
    public Item (ItemDTO itemDTO){
        
    }
    
    /** /
     * This method increases the quantity of an item
     */
    public void incrementQuantityOfItem (){
        quantity++;
    }
    
}
