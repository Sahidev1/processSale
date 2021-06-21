
package se.kth.iv1350.processSale.util;

/**
 * This class represent an amount of money
 * 
 * @author Ali Sahibi
 */
public class Amount implements RoundValue {
    private double value;
    
    /** 
     * Constructor for the class Amount
     * 
     * @param value a double 
     */
    public Amount (double value){
        this.value = value;
    }

    /** 
     * Getter method that retrieves the value of the amount
     * 
     * @return value as double
     */
    public double getValue() {
        return value;
    }
    
    /**
     * Returns rounded value of Amount
     * 
     * @return rounded value of amount
     */
    @Override
    public String getRoundValue (){
        return roundAmount ();
    }
    
    /** 
     * toString method for the class Amount
     * 
     * @return a String which describes an Amount object
     */
    @Override
    public String toString(){
        return String.valueOf(value);
    }
    
    /** 
     * This method performs an addition of two amount objects
     * 
     * @param amount the other amount object to be added
     * @return a sum of the two amounts
     */
    public Amount add (Amount amount){
        return new Amount(value + amount.getValue());
    }
    
    /**
     * This method performs subtraction of two amount objects
     * 
     * @param amount the other amount which is being subtracted
     * @return difference of the two amounts
     */
    public Amount subtract (Amount amount){
        return new Amount(value - amount.getValue());
    }
    
    /**
     * This method performs multiplication of two amount objects
     * 
     * @param amount to be multiplied with
     * @return the product
     */
    public Amount multiply (Amount amount){
        return new Amount(value * amount.getValue());
    }
    
    private String roundAmount (){
        String amountString = String.valueOf(value);
        StringBuilder roundedValue = new StringBuilder ();
        
        int i = 0;
        while (amountString.charAt(i) != '.'){
            roundedValue.append(amountString.charAt(i++));
        }
        roundedValue.append(amountString.charAt(i++));
        
        if (i + 1 == amountString.length()){
            roundedValue.append(amountString.charAt(i));
        }
        
        else {
            roundedValue.append(amountString.charAt(i++));
            if (i + 1 == amountString.length()){
                roundedValue.append(amountString.charAt(i));
            }
            else {
                i++;
                int valCurrentDecimal = Integer.parseInt(String.valueOf(amountString.charAt(i)));
                int valPreviousDecimal = Integer.parseInt(String.valueOf(amountString.charAt(i - 1)));
                if (valCurrentDecimal >= 5){
                    valPreviousDecimal++;
                    roundedValue.append(valPreviousDecimal);
                }
                else {
                    roundedValue.append(valPreviousDecimal);
                }
            }
        }
        
        return roundedValue.toString();
    }
}
