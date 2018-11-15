package payroll;

public class ChainedTaxBand implements TaxBand {
    private final double rate;
    private final int threshold;
    private final long maximumTax;
    private final TaxBand previousTaxBand;

    public ChainedTaxBand(double rate, int threshold, long maximumTax, TaxBand previousTaxBand) {
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
