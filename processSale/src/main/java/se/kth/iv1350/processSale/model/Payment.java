package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ExternalAccounting;
import se.kth.iv1350.processSale.integration.ExternalInventory;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.integration.Printer;
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
    
    public Amount getChange (){
        return  change;
    }
    
    /**
     * This class updates the payment information 
     * 
     * @param saleInformation is updated
     */
    public void updateExternalSystems (){
        ExternalInventory inventory = integrations.getExternalInventory();
        ExternalAccounting accounting = integrations.getExternalAccounting();
        inventory.updateInventory(saleInformation);
        accounting.updateAccounting(saleInformation);
        cashRegister.addToBalance(saleInformation.getPaymentAmount());
        calculateChange();  
    }
    
    public void updateReceipt (){
        receipt.updateReceipt(this);
    }
    
    public SaleInformation getSaleInformation (){
        return this.saleInformation;
    }
    
    /**
     * This method retrieves an IntegrationCreator to give access to classes
     * in the integration layer
     * 
     * @param integrations gives access to integration classes
     * @param cashRegister gives access to the cash register
     * @param printer
     */
    public void givePaymentParts (IntegrationCreator integrations,
    CashRegister cashRegister, Printer printer){
        this.integrations = integrations;
        this.cashRegister = cashRegister;
        receipt.accessPrinter(printer);
    }
    
    public void giveSaleInformation (SaleInformation saleInformation){
        this.saleInformation = saleInformation;
    }
    
    /**
     * Calculates how much change to give back to costumer
     */
    private void calculateChange (){
        this.change = saleInformation.calculateChange();
    }    
}
