package payroll.refactoring06;

/**
 * TaxCalculator is very hard-coded:
 * Data: Tax band limits and rates</para>
 * Structure: Banded structure with four levels
 * Both of these are subject to change
 */
public class TaxCalculator {
    public double getTax(final double grossSalary) {
        final double upperTaxBracketStart = 40000;
        final double upperTaxBracketRate = 0.4;
		final double upperTaxBracketTax = getTaxInBand(grossSalary, upperTaxBracketStart, upperTaxBracketRate);
        final double remainingGrossForMiddleAndLowerBrackets = getGrossToTaxInBandsBelowCurrent(grossSalary, upperTaxBracketStart);
        
        final double middleTaxBracketStart = 20000;
        final double middleTaxBracketRate = 0.2;
		final double middleTaxBracketTax = getTaxInBand(remainingGrossForMiddleAndLowerBrackets, middleTaxBracketStart, middleTaxBracketRate);
        final double remainingGrossForLowerBracket = getGrossToTaxInBandsBelowCurrent(remainingGrossForMiddleAndLowerBrackets, middleTaxBracketStart);
        
        final double lowerTaxBracketStart = 5000;
        final double lowerTaxBracketRate = 0.1;
		final double lowerTaxBracketTax = getTaxInBand(remainingGrossForLowerBracket, lowerTaxBracketStart, lowerTaxBracketRate);
        
		return lowerTaxBracketTax + middleTaxBracketTax + upperTaxBracketTax;
    }

	private double getTaxInBand(final double grossSalaryExcludingPartAlreadyTaxedAtHigherRate, final double bracketMinimumGross, final double taxRate) {
		return getGrossToTaxInBand(grossSalaryExcludingPartAlreadyTaxedAtHigherRate, bracketMinimumGross) * taxRate;
	}

	private double getGrossToTaxInBandsBelowCurrent(final double grossSalary, final double bracketMinimumGross) {
		return Math.min(bracketMinimumGross, grossSalary);
	}

	private double getGrossToTaxInBand(double grossSalaryExcludingPartAlreadyTaxedAtHigherRate, final double bracketMinimumGross) {
		return Math.max(0, grossSalaryExcludingPartAlreadyTaxedAtHigherRate - bracketMinimumGross);
	}
}
