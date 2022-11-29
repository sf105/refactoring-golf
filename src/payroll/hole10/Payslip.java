package payroll.hole10;

public class Payslip {
    private final long grossSalary;
    private final TaxCalculator taxCalculator;

    public Payslip(final long grossSalary, final TaxCalculator taxCalculator) {
        this.grossSalary = grossSalary;
        this.taxCalculator = taxCalculator;
    }

    public long getNet() {
        return grossSalary - taxCalculator.taxFor(grossSalary);
    }
}
