package se.kth.iv1350.processSale.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.controller.OperationFailedException;
import se.kth.iv1350.processSale.integration.CostumerDTO;
import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.integration.ItemNotFoundException;
import se.kth.iv1350.processSale.util.Amount;
import se.kth.iv1350.processSale.util.LogHandler;

/**
 *
 * @author Ali Sahibi
 */
public class CommandLineGUI {
    private Controller contr;
    private ErrorMessageHandler showErrorMsg = new ErrorMessageHandler ();
    private LogHandler logger = LogHandler.getLogHandler();
    private Scanner in;
    private static final String ITEM_NOT_FOUND = "Item could not be found"
                + " in the item registry, Item is invalid";
    private static final String COULD_NOT_SEARCH = "Could not search for item";
    
    /**
     * 
     * 
     * @param contr 
     */
    public CommandLineGUI (Controller contr){
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
        contr.addSaleObserver(new TotalRevenueFileOutput());        
    }
    
    public void runGUI (){
        in = new Scanner(System.in);
        while (true){
            firstOptions ();
            handleItems ();
            discountOptions ();
            handlePayment ();
        }
    }
    
    private void handleItems (){
        boolean isThereMoreItems = true;
        int quantity = 1;
        String Identifier;
        while (isThereMoreItems){
            print ("Are there several units of the item? (Y/N)");
            if (in.nextLine().equalsIgnoreCase("Y")){
                print ("Enter the quantity of the item: ");
                boolean correctInput = false;
                while (!correctInput){
                    try {
                        quantity = in.nextInt();
                        correctInput = true;
                    } catch (InputMismatchException iME){
                        in.nextLine();
                        print ("Please enter a valid quantity!");
                    }
                }
                in.nextLine();
            }
            try {
                print ("Enter the itemIdentifier: ");
                Identifier = in.nextLine();
                print("");
                ItemDTO searchedItem = new ItemDTO (Identifier);
                contr.searchItem(searchedItem, quantity);
                print ("Total cost: " + contr.getRoundedTotalPrice()
                + "\n");
            }
            catch (ItemNotFoundException Iex){
                showErrorMsg.displayError(ITEM_NOT_FOUND);
            }
            catch (OperationFailedException OPexc){
                showErrorMsg.displayError(COULD_NOT_SEARCH);
                logger.writeToLog(OPexc);
            }
            print ("Is there more items to handle? (Y/N)");
            if (in.nextLine().equalsIgnoreCase("N")){
                isThereMoreItems = false;
            }
        }
    }
    
    private void firstOptions (){       
        int choice = 0;
        boolean isInputValid = false;
        
        while (!isInputValid){
            try {
                choice = in.nextInt();
                in.nextLine();
                if (choice != 1 && choice != 2){
                    throw new InvalidInputException ("Please enter 1 or 2");
                }
                
                isInputValid = true;
                if (choice == 1){
                    contr.newSale();
                }
                else if (choice == 2){
                    System.exit(0);
                }              
            } catch (InvalidInputException iIE){
                print (iIE.getMessage());
            }  
        }        
    }
    
    private void discountOptions (){
        print ("Does Costumer requestDiscount? (Y/N)");
        if (in.nextLine().equalsIgnoreCase("Y")){
            print ("Enter costumers name: ");
            String name = in.nextLine();
            print ("Enter costumers DOB: ");
            String DOB = in.nextLine();
            print ("Enter costumers adress: ");
            String adress = in.nextLine();
            print ("Enter costumers social number: ");
            String social = in.nextLine();
            
            CostumerDTO costumer = new CostumerDTO (name, DOB, adress, social);
            Amount price = contr.requestDiscount(costumer);
            print ("Discount request was made");
            print ("Total price: " + contr.getRoundedTotalPrice());
        }   
    }
    
    private void handlePayment (){
        print ("Enter payment from costumer: ");
        Amount paymentFromCostumer = new Amount (in.nextDouble());
        in.nextLine();
        contr.makePayment(paymentFromCostumer);
    }
    
    private void print (String msg){
        System.out.println(msg);
    }
}
