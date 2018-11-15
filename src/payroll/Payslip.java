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
        final TaxBand lowerTaxBand = new TaxBand(lowerTaxRate, lowTaxThreshold);
        final TaxBand middleTaxBand = new TaxBand(middleTaxRate, middleTaxThreshold);
        final TaxBand upperTaxBand = new TaxBand(upperTaxRate, upperTaxThreshold);

        long tax = 0;

        if (grossSalary > lowerTaxBand.threshold) {
            tax = lowerTaxBand.taxForBand(grossSalary);
        }

        if (grossSalary > middleTaxBand.threshold) {
            tax = lowerTaxMaximum + middleTaxBand.taxForBand(grossSalary);
        }

        if (grossSalary > upperTaxBand.threshold) {
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
    }
}
