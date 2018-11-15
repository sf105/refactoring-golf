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
            tax = new TaxBand(lowerTaxRate, lowTaxThreshold).taxForBand(grossSalary);
        }

        if (grossSalary > middleTaxThreshold) {
            tax = lowerTaxMaximum + new TaxBand(middleTaxRate, middleTaxThreshold).taxForBand(grossSalary);
        }

        if (grossSalary > upperTaxThreshold) {
            tax =  lowerTaxMaximum + middleTaxMaximum + new TaxBand(upperTaxRate, upperTaxThreshold).taxForBand(grossSalary);
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
