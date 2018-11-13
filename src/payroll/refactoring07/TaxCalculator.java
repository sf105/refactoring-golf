package payroll.refactoring07;

/**
 * This is better, but notice that it's still got repetition in the way the tax bands
 * are used. Can we make this more regular and simplify the structure?
 */
public class TaxCalculator {
    public double taxFor(final double grossSalary) {
		final TaxBand upperTaxBand = new TaxBand(40000.0, 0.4);
		final double upperTaxBracketTax = upperTaxBand.getTaxInBand(grossSalary);
        final double remainingGrossForMiddleAndLowerBrackets = upperTaxBand.getGrossToTaxInBandsBelowCurrent(grossSalary);

		final TaxBand middleTaxBand = new TaxBand(20000.0, 0.2);
		final double middleTaxBracketTax = middleTaxBand.getTaxInBand(remainingGrossForMiddleAndLowerBrackets);
        final double remainingGrossForLowerBracket = middleTaxBand.getGrossToTaxInBandsBelowCurrent(remainingGrossForMiddleAndLowerBrackets);

		final TaxBand lowerTaxBand = new TaxBand(5000.0, 0.1);
		final double lowerTaxBracketTax = lowerTaxBand.getTaxInBand(remainingGrossForLowerBracket);
        
		return lowerTaxBracketTax + middleTaxBracketTax + upperTaxBracketTax;
    }

	private static class TaxBand {
		private final double bracketMinimumGross;
		private final double taxRate;

		private TaxBand(double bracketMinimumGross, double taxRate) {
			this.bracketMinimumGross = bracketMinimumGross;
			this.taxRate = taxRate;
		}

		private double getGrossToTaxInBand(double grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
			return Math.max(0, grossSalaryExcludingPartAlreadyTaxedAtHigherRate - bracketMinimumGross);
		}

		private double getGrossToTaxInBandsBelowCurrent(final double grossSalary) {
			return Math.min(bracketMinimumGross, grossSalary);
		}

		private double getTaxInBand(final double grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
			return getGrossToTaxInBand(grossSalaryExcludingPartAlreadyTaxedAtHigherRate) * taxRate;
		}
	}
}
