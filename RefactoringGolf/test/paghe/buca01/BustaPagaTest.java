/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paghe.buca01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author marce
 */
public class BustaPagaTest {
    
    public BustaPagaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNetto method, of class BustaPaga.
     */
    
    
    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        BustaPaga bustaPaga = new BustaPaga(5000);
        assertEquals(5000, bustaPaga.getNetto(), 1e-6);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        final BustaPaga bustaPaga = new BustaPaga(10000);
        assertEquals(9500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(20000);
        assertEquals(18500, bustaPaga2.getNetto(), 1e-6);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        final BustaPaga bustaPaga = new BustaPaga(25000);
        assertEquals(22500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(40000);
        assertEquals(34500, bustaPaga2.getNetto(), 1e-6);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        final BustaPaga bustaPaga = new BustaPaga(50000);
        assertEquals(40500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(60000);
        assertEquals(46500, bustaPaga2.getNetto(), 1e-6);
    }
}
