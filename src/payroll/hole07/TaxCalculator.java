package payroll.hole07;

public class TaxCalculator {
    public long taxFor(final long grossSalary) {
		final TaxBand upperTaxBand = new TaxBand(40000, 0.4);
		final long upperTaxBracketTax = upperTaxBand.taxInBand(grossSalary);
        final long remainingGrossForMiddleAndLowerBrackets = upperTaxBand.grossToTaxInBandsBelowCurrent(grossSalary);

		final TaxBand middleTaxBand = new TaxBand(20000, 0.2);
		final long middleTaxBracketTax = middleTaxBand.taxInBand(remainingGrossForMiddleAndLowerBrackets);
        final long remainingGrossForLowerBracket = middleTaxBand.grossToTaxInBandsBelowCurrent(remainingGrossForMiddleAndLowerBrackets);

		final TaxBand lowerTaxBand = new TaxBand(5000, 0.1);
		final long lowerTaxBracketTax = lowerTaxBand.taxInBand(remainingGrossForLowerBracket);
        
		return lowerTaxBracketTax + middleTaxBracketTax + upperTaxBracketTax;
    }

	private static class TaxBand {
		private final long minimumGross;
		private final double taxRate;

		private TaxBand(long minimumGross, double taxRate) {
			this.minimumGross = minimumGross;
			this.taxRate = taxRate;
		}

		private long grossToTaxInBand(long grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
			return Math.max(0, grossSalaryExcludingPartAlreadyTaxedAtHigherRate - minimumGross);
		}

		private long grossToTaxInBandsBelowCurrent(final long grossSalary) {
			return Math.min(grossSalary, minimumGross);
		}

		private long taxInBand(final long grossSalaryExcludingPartAlreadyTaxedAtHigherRate) {
			return Math.round(grossToTaxInBand(grossSalaryExcludingPartAlreadyTaxedAtHigherRate) * taxRate);
		}
	}
}
