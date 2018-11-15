package payroll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayslipTest {
    @Test public void
    no_tax_for_salary_below_threshold() {
        assertEquals(5000, new Payslip(5000).netSalary());
    }

    @Test public void
    low_rate_tax_for_salary_in_lower_rate_band() {
        final long netSalary = 5000 + 13500;
        assertEquals(netSalary, new Payslip(20000).netSalary());
    }


    public static class Payslip {
        private final long grossSalary;

        public Payslip(long grossSalary) {
            this.grossSalary = grossSalary;
        }

        public long netSalary() {
            if (grossSalary <= 5000) return grossSalary;

            long taxable = grossSalary - 5000;

            return grossSalary - Math.round(taxable * 0.1);
        }
    }
}
