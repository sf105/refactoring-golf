package payroll.hole09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
    @Test
    public void netIsGrossMinusTax() {
        final Payslip payslip = new Payslip(5000, grossSalary -> 500);
		assertEquals(4500, payslip.getNet(), 1e-6);
    }
}
