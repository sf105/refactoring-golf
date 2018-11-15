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

    @Test public void
    mid_rate_tax_for_salary_in_mid_rate_band() {
        final long netSalary = 5000 + 13500 + 16000;
        assertEquals(netSalary, new Payslip(40000).netSalary());
    }

    @Test public void
    upper_rate_tax_for_salary_in_upper_rate_band() {
        final long netSalary = 5000 + 13500 + 16000 + 600;
        assertEquals(netSalary, new Payslip(41000).netSalary());
    }


    public static class Payslip {
        private final long grossSalary;

        public Payslip(long grossSalary) {
            this.grossSalary = grossSalary;
        }

        public long netSalary() {
            if (grossSalary <= 5000) return grossSalary;

            if (grossSalary <= 20000) {
                return grossSalary - Math.round((grossSalary - 5000) * 0.1);
            }

            if (grossSalary <= 40000) {
                return grossSalary - 1500 - Math.round((grossSalary - 20000) * 0.2);
            }

            return grossSalary - 1500 - 4000 - Math.round((grossSalary - 40000) * 0.4);

        }
    }
}
