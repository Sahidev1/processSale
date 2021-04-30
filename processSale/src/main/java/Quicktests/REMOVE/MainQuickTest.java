package Quicktests.REMOVE;

import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.util.Amount;
import se.kth.iv1350.processSale.util.Percentage;

/**
 *
 * @author Ali Sahibi
 */
public class MainQuickTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Amount amt = new Amount (22);
        Percentage prt = new Percentage (11);
        
        ItemDTO item = new ItemDTO ("asdjk299", "apple", amt, prt);
        System.out.println (item.toString());
    }
    
}
