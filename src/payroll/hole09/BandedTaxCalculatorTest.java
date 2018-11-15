package payroll.hole09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BandedTaxCalculatorTest {
	private static final double RATE_FOR_BAND = 0.1;
	private static final int MINIMUM_GROSS_FOR_BAND = 1000;
	private static final int TAX_FROM_LOWER_BAND = 1;
	
	private BandedTaxCalculator calculator = new BandedTaxCalculator(MINIMUM_GROSS_FOR_BAND, RATE_FOR_BAND, new TaxCalculator() {
		@Override
		public double taxFor(double grossSalary) {
			return TAX_FROM_LOWER_BAND;
		}
	});
	
	@Test
	public void lowerBandTaxIsZeroIfLowerBandCalculatorIsNull() {
		BandedTaxCalculator calculator = new BandedTaxCalculator(MINIMUM_GROSS_FOR_BAND, RATE_FOR_BAND, null);
		assertEquals(RATE_FOR_BAND * (2000 - MINIMUM_GROSS_FOR_BAND), calculator.taxFor(2000), 0);
	}

	@Test
	public void allTaxIsFromLowerBandsIfGrossSalaryIsLessThanMinimumForBand() {
		assertEquals(TAX_FROM_LOWER_BAND, calculator.taxFor(MINIMUM_GROSS_FOR_BAND), 0);
	}
	
	@Test
	public void taxIsSumOfTaxFromLowerBandsAndTaxFromThisBand() {
		assertEquals(TAX_FROM_LOWER_BAND + RATE_FOR_BAND * (2000 - MINIMUM_GROSS_FOR_BAND), calculator.taxFor(2000), 0);
	}
}
