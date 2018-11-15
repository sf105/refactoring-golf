package payroll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
    @Test public void
    no_tax_for_salary_below_threshold() {
        assertEquals(500, new Payslip(500).netSalary());
    }

    public static class Payslip {
        private final long grossSalary;

        public Payslip(long grossSalary) {
            this.grossSalary = grossSalary;
        }

        public long netSalary() {
            return grossSalary;
        }
    }
}
