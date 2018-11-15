package payroll;

public class Payslip {
    private final long grossSalary;
    private final TaxCalculator taxCalculator;

    public Payslip(long grossSalary) {
        this.grossSalary = grossSalary;
        taxCalculator = new TaxCalculator();
    }

    public long netSalary() {
        return grossSalary - taxCalculator.taxFor(grossSalary);
    }

}
