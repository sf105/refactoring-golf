package payroll.hole07;

public class TaxCalculator {
    public double taxFor(final double grossSalary) {
		final TaxBand upperTaxBand = new TaxBand(40000.0, 0.4);
		final double upperTaxBracketTax = upperTaxBand.taxInBand(grossSalary);
        final double remainingGrossForMiddleAndLowerBrackets = upperTaxBand.grossToTaxInBandsBelowCurrent(grossSalary);

		final TaxBand middleTaxBand = new TaxBand(20000.0, 0.2);
		final double middleTaxBracketTax = middleTaxBand.taxInBand(remainingGrossForMiddleAndLowerBrackets);
        final double remainingGrossForLowerBracket = middleTaxBand.grossToTaxInBandsBelowCurrent(remainingGrossForMiddleAndLowerBrackets);

		final TaxBand lowerTaxBand = new TaxBand(5000.0, 0.1);
		final double lowerTaxBracketTax = lowerTaxBand.taxInBand(remainingGrossForLowerBracket);
        
		return lowerTaxBracketTax + middleTaxBracketTax + upperTaxBracketTax;
    }

	private static class TaxBand {
		private final double minimumGross;
		private final double taxRate;

		private TaxBand(double minimumGross, double taxRate) {
			this.minimumGross = minimumGross;
			this.taxRate = taxRate;
		}

		private double grossToTaxInBand(double grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
			return Math.max(0, grossSalaryExcludingPartAlreadyTaxedAtHigherRate - minimumGross);
		}

		private double grossToTaxInBandsBelowCurrent(final double grossSalary) {
			return Math.min(grossSalary, minimumGross);
		}

		private double taxInBand(final double grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
			return grossToTaxInBand(grossSalaryExcludingPartAlreadyTaxedAtHigherRate) * taxRate;
		}
	}
}
