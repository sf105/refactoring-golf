package payroll.hole06;

public class TaxCalculator {
    public long taxFor(final long grossSalary) {
        final long upperTaxBracketStart = 40000;
        final double upperTaxBracketRate = 0.4;
		final long upperTaxBracketTax = taxInBand(grossSalary, upperTaxBracketStart, upperTaxBracketRate);
        final long remainingGrossForMiddleAndLowerBrackets = grossToTaxInBandsBelowCurrent(grossSalary, upperTaxBracketStart);
        
        final long middleTaxBracketStart = 20000;
        final double middleTaxBracketRate = 0.2;
		final long middleTaxBracketTax = taxInBand(remainingGrossForMiddleAndLowerBrackets, middleTaxBracketStart, middleTaxBracketRate);
        final long remainingGrossForLowerBracket = grossToTaxInBandsBelowCurrent(remainingGrossForMiddleAndLowerBrackets, middleTaxBracketStart);
        
        final long lowerTaxBracketStart = 5000;
        final double lowerTaxBracketRate = 0.1;
		final long lowerTaxBracketTax = taxInBand(remainingGrossForLowerBracket, lowerTaxBracketStart, lowerTaxBracketRate);
        
		return lowerTaxBracketTax + middleTaxBracketTax + upperTaxBracketTax;
    }

	private long taxInBand(final long grossSalaryExcludingPartAlreadyTaxedAtHigherRate, final long bracketMinimumGross, final double taxRate) {
		return Math.round(grossToTaxInBand(grossSalaryExcludingPartAlreadyTaxedAtHigherRate, bracketMinimumGross) * taxRate);
	}

	private long grossToTaxInBandsBelowCurrent(final long grossSalary, final long bracketMinimumGross) {
		return Math.min(grossSalary, bracketMinimumGross);
	}

	private long grossToTaxInBand(long grossSalaryExcludingPartAlreadyTaxedAtHigherRate, final long bracketMinimumGross) {
		return Math.max(0, grossSalaryExcludingPartAlreadyTaxedAtHigherRate - bracketMinimumGross);
	}
}
