package payroll;

public interface TaxBand {
    boolean appliesTo(long grossSalary);

    long taxFor(long grossSalary);

    long maximumTaxSoFar();
}
