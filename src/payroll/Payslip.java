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
        final int lowerTaxMaximum = 1500;
        final int middleTaxMaximum = 4000;
        final TaxBand lowerTaxBand = new TaxBand(0.1, 5000);
        final TaxBand middleTaxBand = new TaxBand(0.2, 20000);
        final TaxBand upperTaxBand = new TaxBand(0.4, 40000);

        long tax = 0;

        if (lowerTaxBand.aboveThreshold(grossSalary)) {
            tax = lowerTaxBand.taxForBand(grossSalary);
        }

        if (middleTaxBand.aboveThreshold(grossSalary)) {
            tax = lowerTaxMaximum + middleTaxBand.taxForBand(grossSalary);
        }

        if (upperTaxBand.aboveThreshold(grossSalary)) {
            tax =  lowerTaxMaximum + middleTaxMaximum + upperTaxBand.taxForBand(grossSalary);
        }
        return tax;
    }

    private static class TaxBand {
        private final double rate;
        private final int threshold;

        private TaxBand(double rate, int threshold) {
            this.rate = rate;
            this.threshold = threshold;
        }

        public double getRate() {
            return rate;
        }

        public int getThreshold() {
            return threshold;
        }

        private long taxForBand(long grossSalary) {
            return Math.round((grossSalary - getThreshold()) * getRate());
        }

        private boolean aboveThreshold(long grossSalary) {
            return grossSalary > threshold;
        }
    }
}
