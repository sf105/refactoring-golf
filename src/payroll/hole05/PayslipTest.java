package payroll.hole05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayslipTest {
    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        assertNetGivenGross(5000, 5000);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        assertNetGivenGross(10000, 9500);
        assertNetGivenGross(20000, 18500);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        assertNetGivenGross(25000, 22500);
        assertNetGivenGross(40000, 34500);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        assertNetGivenGross(50000, 40500);
        assertNetGivenGross(60000, 46500);
    }

    private void assertNetGivenGross(final int gross, final int expectedNet) {
        final Payslip payslip = new Payslip(gross, new TaxCalculator());
        assertEquals(expectedNet, payslip.getNet(), 1e-6);
    }
}
