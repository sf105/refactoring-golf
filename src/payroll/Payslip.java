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
            tax = taxForBand(grossSalary, lowerTaxRate, lowTaxThreshold);
        }

        if (grossSalary > middleTaxThreshold) {
            tax = lowerTaxMaximum + taxForBand(grossSalary, middleTaxRate, middleTaxThreshold);
        }

        if (grossSalary > upperTaxThreshold) {
            tax =  lowerTaxMaximum + middleTaxMaximum + taxForBand(grossSalary, upperTaxRate, upperTaxThreshold);
        }
        return tax;
    }

    private long taxForBand(long grossSalary, double rate, int threshold) {
        return Math.round((grossSalary - threshold) * rate);
    }
}
