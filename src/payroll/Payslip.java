package payroll;

public class Payslip {
    private final long grossSalary;

    public Payslip(long grossSalary) {
        this.grossSalary = grossSalary;
    }

    public long netSalary() {
        return grossSalary - taxFor(grossSalary);
    }

    private long taxFor(long grossSalary) {
        final double lowerTaxRate = 0.1;
        final int lowTaxThreshold = 5000;
        final int lowerTaxMaximum = 1500;
        final double middleTaxRate = 0.2;
        final int middleTaxThreshold = 20000;
        final int middleTaxMaximum = 4000;
        final double upperTaxRate = 0.4;
        final int upperTaxThreshold = 40000;

        long tax = 0;

        if (grossSalary > lowTaxThreshold) {
            tax = Math.round((grossSalary - lowTaxThreshold) * lowerTaxRate);
        }

        if (grossSalary > middleTaxThreshold) {
            tax = lowerTaxMaximum + Math.round((grossSalary - middleTaxThreshold) * middleTaxRate);
        }

        if (grossSalary > upperTaxThreshold) {
            tax =  lowerTaxMaximum + middleTaxMaximum + Math.round((grossSalary - upperTaxThreshold) * upperTaxRate);
        }
        return tax;
    }
}
