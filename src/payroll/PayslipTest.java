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


}
