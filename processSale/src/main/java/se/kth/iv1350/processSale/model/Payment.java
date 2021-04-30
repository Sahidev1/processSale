package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.util.Amount;

/**
 * This class deals with the payment process of the sale
 * 
 * @author Ali Sahibi
 */
public class Payment {
    private Amount change;
    private SaleInformation saleInformation;
    
    /**
     * Constructor for the class Payment
     */
    public Payment (){
        
    }
    
    /**
     * This class updates the payment information 
     * 
     * @param paymentAmount amount paid by costumer
     */
    public void updatePayment (SaleInformation saleInformation){
        this.saleInformation = saleInformation;    
    }
    
    /**
     * This method retrieves an IntegrationCreator to give access to classes
     * in the integration layer
     * 
     * @param integrationCreator gives access to integration classes
     * @param cashRegister gives access to the cash register
     */
    public void getPaymentParts (IntegrationCreator integrationCreator,
    CashRegister cashRegister){
    
    }
    
    /**
     * Calculates how much change to give back to costumer
     */
    private void calculateChange (){
        this.change = saleInformation.calculateChange();
    }    
}
