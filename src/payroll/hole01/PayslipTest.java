package payroll.hole01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
    @Test
    public void taxIsZeroIfGrossIsBelowTaxFreeLimit() {
        Payslip payslip = new Payslip(5000);
        assertEquals(5000, payslip.getNet());
    }

    @Test
    public void taxOnAmountInLowerTaxBracketExcludesTaxFreeLimit() {
        final Payslip payslip = new Payslip(10000);
        assertEquals(9500, payslip.getNet());

        final Payslip payslip2 = new Payslip(20000);
        assertEquals(18500, payslip2.getNet());
    }

    @Test
    public void taxOnAmountInMiddleTaxBracketIsSumOfLowerTaxBracketAmountAndAdditionalMiddleTaxBracketAmount() {
        final Payslip payslip = new Payslip(25000);
        assertEquals(22500, payslip.getNet());

        final Payslip payslip2 = new Payslip(40000);
        assertEquals(34500, payslip2.getNet());
    }

    @Test
    public void taxOnAmountInUpperTaxBracketIsSumOfLowerTaxBracketAmountAndMiddleTaxBracketAmountAndAdditionalUpperTaxBracketAmount() {
        final Payslip payslip = new Payslip(50000);
        assertEquals(40500, payslip.getNet());

        final Payslip payslip2 = new Payslip(60000);
        assertEquals(46500, payslip2.getNet());
    }
}
