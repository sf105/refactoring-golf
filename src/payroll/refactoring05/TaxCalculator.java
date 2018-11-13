package payroll.refactoring05;

/**
 * The TaxCalculator code does not represent the domain well:
 * The first £5,000 is tax free
 * Up to £20,000 is taxed at 10%
 * Up to £40,000 is taxed at 20%
 * Above £40,000 is taxed at 40%
 */

public class TaxCalculator {
    public double taxFor(final double grossSalary) {
        final double taxFreeGross = Math.min(5000, grossSalary);
        final double lowerTaxBracketGross = Math.min(grossSalary - taxFreeGross, 15000);
        final double middleTaxBracketGross = Math.min(grossSalary - lowerTaxBracketGross - taxFreeGross, 20000);
        final double upperTaxBracketGross = Math.min(grossSalary - middleTaxBracketGross - lowerTaxBracketGross - taxFreeGross, 20000);
        return lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4;
    }
}
