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
        final TaxBand lowerTaxBand = new TaxBand(0.1, 5000, 1500, null);
        final TaxBand middleTaxBand = new TaxBand(0.2, 20000, 4000, lowerTaxBand);
        final TaxBand upperTaxBand = new TaxBand(0.4, 40000, 0, middleTaxBand);

        long tax = 0;

        if (lowerTaxBand.appliesTo(grossSalary)) {
            tax = lowerTaxBand.taxForBand(grossSalary);
        }

        if (middleTaxBand.appliesTo(grossSalary)) {
            tax = lowerTaxBand.maximumTax + middleTaxBand.taxForBand(grossSalary);
        }

        if (upperTaxBand.appliesTo(grossSalary)) {
            tax =  lowerTaxBand.maximumTax + middleTaxBand.maximumTax + upperTaxBand.taxForBand(grossSalary);
        }
        return tax;
    }

    private static class TaxBand {
        private final double rate;
        private final int threshold;
        private final long maximumTax;
        private final TaxBand previousTaxBand;

        private TaxBand(double rate, int threshold, long maximumTax, TaxBand previousTaxBand) {
            this.rate = rate;
            this.threshold = threshold;
            this.maximumTax = maximumTax;
            this.previousTaxBand = previousTaxBand;
        }

        private long taxForBand(long grossSalary) {
            return Math.round((grossSalary - threshold) * rate);
        }

        private boolean appliesTo(long grossSalary) {
            return grossSalary > threshold;
        }
    }
}
