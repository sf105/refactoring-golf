package bustapaga.buca10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BustaPagaTaxTest10 {
    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        assertNetForGross(5000, 5000);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        assertNetForGross(10000, 9500);
        assertNetForGross(20000, 18500);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        assertNetForGross(25000, 22500);
        assertNetForGross(40000, 34500);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        assertNetForGross(50000, 40500);
        assertNetForGross(60000, 46500);
    }

    private void assertNetForGross(final int gross, final int expectedNet) {
        final BustaPaga bustaPaga = new BustaPaga(gross,
                new CalcolatoreScaglioneTasse(40000, 0.4,
                        new CalcolatoreScaglioneTasse(20000, 0.2,
                                new CalcolatoreScaglioneTasse(5000, 0.1,
                                        new CalcolatoreTasseNullo()))));
        assertEquals(expectedNet, bustaPaga.getNetto(), 1e-6);
    }
}
