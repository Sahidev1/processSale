package se.kth.iv1350.processSale.model;

import java.util.Date;
import se.kth.iv1350.processSale.integration.Printer;

/**
 * The receipt contains a string with all the sale information 
 *
 * @author Ali Sahibi
 */
public class Receipt {
    private Payment payment;
    private Printer printer;
    
    /** 
     * Constructor for the class Receipt
     */
    public Receipt (){
        
    }
    
    /** 
     * This method updates the receipt with the current sale information
     * 
     * @param saleInformation 
     */
    public void updateReceipt (Payment payment){
        this.payment = payment;
        printer.printReceipt(this);
    }
    
    /** 
     * This method gives the Receipt object access to a printer
     * 
     * @param printer that receipt will access
     */
    public void accessPrinter (Printer printer){
        this.printer = printer;
    }
    
    @Override
    public String toString (){
        StringBuilder receiptString = new StringBuilder ();
        
        SaleInformation saleInfo = payment.getSaleInformation();
        Date timeOfSale = saleInfo.getTimeOfSale();
        Store store = saleInfo.getStore();
        
        receiptString.append("Time of sale: ");
        receiptString.append(timeOfSale);
        newLine (receiptString);
        newLine (receiptString);
        
        receiptString.append (store.getStoreName());
        newLine (receiptString);
        
        receiptString.append(store.getStreetAdress());
        newLine (receiptString);
        receiptString.append(store.getZip());
        receiptString.append(" ");
        receiptString.append(store.getCity());
        newLine (receiptString);
        newLine (receiptString);
        
        receiptString.append ("---------------- Sale items "
                + "----------------");
        newLine (receiptString);
        newLine (receiptString);
        receiptString.append(saleInfo.saleItemsToString());
        
        receiptString.append("---------------- Sale data "
                + "----------------");
        newLine (receiptString);
        newLine (receiptString);
        receiptString.append("Total price: ").append(saleInfo.getTotalPrice());
        newLine (receiptString);
        receiptString.append("VAT: ").append(saleInfo.getPaidInVAT());
        newLine (receiptString);
        receiptString.append("Costumer payment: ").append(saleInfo.getPaymentAmount());
        newLine (receiptString);
        receiptString.append("Change to costumer: ").append(payment.getChange());
        
        return receiptString.toString();
    }
    
    private void newLine (StringBuilder string){
        string.append("\n");
    }
    
    
}
