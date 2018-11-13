package payroll.hole06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
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
        final Payslip payslip = new Payslip(gross, new TaxCalculator());
        assertEquals(expectedNet, payslip.getNet(), 1e-6);
    }
}
