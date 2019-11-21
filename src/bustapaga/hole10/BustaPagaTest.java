package bustapaga.hole10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BustaPagaTest {
    @Test
    public void netIsGrossMinusTax() {
        final Payslip payslip = new Payslip(5000, grossSalary -> 500);
		assertEquals(4500, payslip.getNet(), 1e-6);
    }
}
