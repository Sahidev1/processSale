package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.util.Amount;

/**
 * This class holds information about the cash registers balance during the 
 * sale
 *
 * @author Ali Sahibi
 */
public class CashRegister {
    private Amount balance;
    
    /** 
     * Constructor for the class CashRegister
     */
    public CashRegister (){
        
    }
    
    /** 
     * This method adds an amount to the current balance
     * 
     * @param amount to add
     */
    public void addToBalance (Amount amount){
        balance = balance.add(amount);
    }

}
