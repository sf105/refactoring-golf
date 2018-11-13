package payroll.hole06;

public class TaxCalculator {
    public double taxFor(final double grossSalary) {
        final double upperTaxBracketStart = 40000;
        final double upperTaxBracketRate = 0.4;
		final double upperTaxBracketTax = taxInBand(grossSalary, upperTaxBracketStart, upperTaxBracketRate);
        final double remainingGrossForMiddleAndLowerBrackets = grossToTaxInBandsBelowCurrent(grossSalary, upperTaxBracketStart);
        
        final double middleTaxBracketStart = 20000;
        final double middleTaxBracketRate = 0.2;
		final double middleTaxBracketTax = taxInBand(remainingGrossForMiddleAndLowerBrackets, middleTaxBracketStart, middleTaxBracketRate);
        final double remainingGrossForLowerBracket = grossToTaxInBandsBelowCurrent(remainingGrossForMiddleAndLowerBrackets, middleTaxBracketStart);
        
        final double lowerTaxBracketStart = 5000;
        final double lowerTaxBracketRate = 0.1;
		final double lowerTaxBracketTax = taxInBand(remainingGrossForLowerBracket, lowerTaxBracketStart, lowerTaxBracketRate);
        
		return lowerTaxBracketTax + middleTaxBracketTax + upperTaxBracketTax;
    }

	private double taxInBand(final double grossSalaryExcludingPartAlreadyTaxedAtHigherRate, final double bracketMinimumGross, final double taxRate) {
		return grossToTaxInBand(grossSalaryExcludingPartAlreadyTaxedAtHigherRate, bracketMinimumGross) * taxRate;
	}

	private double grossToTaxInBandsBelowCurrent(final double grossSalary, final double bracketMinimumGross) {
		return Math.min(grossSalary, bracketMinimumGross);
	}

	private double grossToTaxInBand(double grossSalaryExcludingPartAlreadyTaxedAtHigherRate, final double bracketMinimumGross) {
		return Math.max(0, grossSalaryExcludingPartAlreadyTaxedAtHigherRate - bracketMinimumGross);
	}
}
