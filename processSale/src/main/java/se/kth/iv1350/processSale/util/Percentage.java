package se.kth.iv1350.processSale.util;

/**
 * This class represents a percentage
 * 
 * @author Ali Sahibi
 */
public class Percentage {
    private double percent;
    private final String percentSymbol = "%";
    
    /** /
     * Constructor for the class Percentage
     * 
     * @param percent 
     */
    public Percentage (double percent){
        this.percent = percent;
    }
    
    /** /
     * toString method for the class Percentage
     * 
     * @return a String which describes a percentage
     */
    public String toString (){
        return String.valueOf(percent) + percentSymbol;
    }
    
    

}
