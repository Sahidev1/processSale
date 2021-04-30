package se.kth.iv1350.processSale.integration;

/**
 * A CostumerDTO holds data about a Costumer
 * 
 * @author Ali Sahibi
 */
public class CostumerDTO {
    private String name;
    private String dateOfBirth;
    private String adress;
    private String socialSecurityNumber;
    
    /** /
     * Constructor for the CostumerDTO class
     * 
     * @param name of the Costumer
     * @param dateOfBirth of the Costumer
     * @param adress of the Costumer
     * @param socialSecurityNumber of the Costumer
     */
    public CostumerDTO(String name, String dateOfBirth, String adress, String socialSecurityNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.socialSecurityNumber = socialSecurityNumber;
    }
    
    
}
