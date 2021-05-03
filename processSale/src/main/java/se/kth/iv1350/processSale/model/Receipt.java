package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Printer;

/**
 * The receipt contains a string with all the sale information 
 *
 * @author Ali Sahibi
 */
public class Receipt {
    private SaleInformation saleInformation;
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
    public void updateReceipt (SaleInformation saleInformation){
        this.saleInformation = saleInformation;
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
    
    
}
