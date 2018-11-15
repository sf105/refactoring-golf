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
        final TaxBand nilTaxBand = new TaxBand() {
            @Override public boolean appliesTo(long grossSalary) { return false; }
            @Override public long taxFor(long grossSalary) { return 0; }
            @Override public long maximumTaxSoFar() { return 0; }
        };
        final TaxBand lowerTaxBand = new ChainedTaxBand(0.1, 5000, 1500, nilTaxBand);
        final TaxBand middleTaxBand = new ChainedTaxBand(0.2, 20000, 4000, lowerTaxBand);
        final TaxBand upperTaxBand = new ChainedTaxBand(0.4, 40000, 0, middleTaxBand);


        long tax = 0;

        if (lowerTaxBand.appliesTo(grossSalary)) {
            tax = lowerTaxBand.taxFor(grossSalary);
        }

        if (middleTaxBand.appliesTo(grossSalary)) {
            tax = middleTaxBand.taxFor(grossSalary);
        }

        if (upperTaxBand.appliesTo(grossSalary)) {
            tax =  upperTaxBand.taxFor(grossSalary);
        }
        return tax;
    }

    public static class ChainedTaxBand implements TaxBand {
        private final double rate;
        private final int threshold;
        private final long maximumTax;
        private final TaxBand previousTaxBand;

        private ChainedTaxBand(double rate, int threshold, long maximumTax, TaxBand previousTaxBand) {
            this.rate = rate;
            this.threshold = threshold;
            this.maximumTax = maximumTax;
            this.previousTaxBand = previousTaxBand;
        }

        private long taxForBand(long grossSalary) {
            return Math.round((grossSalary - threshold) * rate);
        }

        @Override
        public boolean appliesTo(long grossSalary) {
            return grossSalary > threshold;
        }

        @Override
        public long taxFor(long grossSalary) {
            return previousTaxBand.maximumTaxSoFar() + taxForBand(grossSalary);
        }

        @Override
        public long maximumTaxSoFar() {
            return maximumTax + previousTaxBand.maximumTaxSoFar();
        }
    }
}
