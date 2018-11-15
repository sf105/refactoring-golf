package payroll;

public interface TaxBand {
    final static TaxBand NIL_TAX_BAND = new TaxBand() {
        @Override public boolean appliesTo(long grossSalary) { return false; }
        @Override public long taxFor(long grossSalary) { return 0; }
        @Override public long maximumTaxSoFar() { return 0; }
    };

    boolean appliesTo(long grossSalary);
    long taxFor(long grossSalary);
    long maximumTaxSoFar();

}
