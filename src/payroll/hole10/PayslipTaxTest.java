package payroll.hole10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTaxTest {
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
        final Payslip payslip = new Payslip(gross,
                new BandedTaxCalculator(40000, 0.4,
                        new BandedTaxCalculator(20000, 0.2,
                                new BandedTaxCalculator(5000, 0.1,
                                        new NullTaxCalculator()))));
        assertEquals(expectedNet, payslip.getNet(), 1e-6);
    }
}
