package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;

/**
 *  View is the programs user interface
 * 
 * @author Ali Sahibi
 */
public class View {
    private Controller contr;
    
    /** /
     * Constructor for the class View
     * 
     * @param contr Controller object used as argument 
     */
    public View(Controller contr){
        this.contr = contr;
    }
}
