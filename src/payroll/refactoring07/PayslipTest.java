package payroll.refactoring07;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayslipTest {
    @Test
    public void netIsGrossMinusTax() {
        final Payslip payslip = new Payslip(5000, new TaxCalculator() {
			@Override
			public double getTax(double grossSalary) {
				return 500;
			}
		});
		assertEquals(4500, payslip.getNet(), 1e-6);
    }
}
