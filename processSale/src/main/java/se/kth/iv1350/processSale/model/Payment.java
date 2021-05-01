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
    private Receipt receipt;
    private IntegrationCreator integrations;
    private CashRegister cashRegister;
    
    /**
     * Constructor for the class Payment
     */
    public Payment (){
        this.receipt = new Receipt();
    }
    
    /**
     * This class updates the payment information 
     * 
     * @param saleInformation is updated
     */
    public void updatePayment (SaleInformation saleInformation){
        this.saleInformation = saleInformation;    
    }
    
    /**
     * This method retrieves an IntegrationCreator to give access to classes
     * in the integration layer
     * 
     * @param integrations gives access to integration classes
     * @param cashRegister gives access to the cash register
     */
    public void givePaymentParts (IntegrationCreator integrations,
    CashRegister cashRegister){
        this.integrations = integrations;
        this.cashRegister = cashRegister;
    }
    
    /**
     * Calculates how much change to give back to costumer
     */
    private void calculateChange (){
        this.change = saleInformation.calculateChange();
    }    
}
