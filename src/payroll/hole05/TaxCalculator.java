package payroll.hole05;

public class TaxCalculator {
    public long taxFor(final long grossSalary) {
        final long lowerTaxBracketGross = Math.max(Math.min(grossSalary, 20000) - 5000, 0);
        final long middleTaxBracketGross = Math.max(Math.min(grossSalary, 40000) - 20000, 0);
        final long upperTaxBracketGross = Math.max(grossSalary - 40000, 0);
        return Math.round(lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4);
    }
}
