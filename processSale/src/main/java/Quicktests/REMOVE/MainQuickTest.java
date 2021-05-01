package Quicktests.REMOVE;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.IntegrationCreator;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.model.Sale;

/**
 *
 * @author Ali Sahibi
 */
public class MainQuickTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegrationCreator integ = new IntegrationCreator();
        Printer printer = new Printer();
        Controller contr = new Controller (integ, printer);
        
        Sale sale = contr.newSale();
        
    }
    
}
