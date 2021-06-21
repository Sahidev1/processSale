/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.processSale.util;

import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ali Sahibi
 */
public class AmountTest {
    private Amount amt0;
    private Amount amt1;
    
    @BeforeEach
    public void setUp() {
        amt0 = new Amount (27);
        amt1 = new Amount (46.23523);
    }
    
    @AfterEach
    public void tearDown() {
        amt0 = null;
        amt1 = null;
    }

    @Test
    public void testGetRoundValue (){
        String roundedAmt0 = amt0.getRoundValue();
        String expValue = "27.0";
        
        boolean condition = roundedAmt0.equals(expValue);
        assertTrue (condition, "doesnt work");
    }
    
    @Test
    public void testGetRoundValueCaseUpwardsRounding (){
        String roundedAmt1 = amt1.getRoundValue();
        String expValue = "46.24";
        
        boolean condition = roundedAmt1.equals(expValue);
        assertTrue (condition, "false");
    }
    
    @Test
    public void testGetRoundValueDownwardsRounding (){
        Amount downwards = new Amount (97.7723);
        String roundedAmt = downwards.getRoundValue();
        String expValue = "97.77";
        
        boolean condition = roundedAmt.equals(expValue);
        assertTrue (condition, "didnt work");
    }
    
}
