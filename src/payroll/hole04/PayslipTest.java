package payroll.hole04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        Payslip payslip = new Payslip(5000, new TaxCalculator());
        assertEquals(5000, payslip.getNet(), 1e-6);
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        final Payslip payslip = new Payslip(10000, new TaxCalculator());
        assertEquals(9500, payslip.getNet(), 1e-6);

        final Payslip payslip2 = new Payslip(20000, new TaxCalculator());
        assertEquals(18500, payslip2.getNet(), 1e-6);
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        final Payslip payslip = new Payslip(25000, new TaxCalculator());
        assertEquals(22500, payslip.getNet(), 1e-6);

        final Payslip payslip2 = new Payslip(40000, new TaxCalculator());
        assertEquals(34500, payslip2.getNet(), 1e-6);
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        final Payslip payslip = new Payslip(50000, new TaxCalculator());
        assertEquals(40500, payslip.getNet(), 1e-6);

        final Payslip payslip2 = new Payslip(60000, new TaxCalculator());
        assertEquals(46500, payslip2.getNet(), 1e-6);
    }
}
