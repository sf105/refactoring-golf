package payroll.hole09;


public class BandedTaxCalculator implements TaxCalculator {
	private final long minimumGross;
	private final double taxRate;
	private final TaxCalculator lowerBandCalculator;

	public BandedTaxCalculator(long minimumGross, double taxRate, TaxCalculator lowerBandCalculator) {
		this.minimumGross = minimumGross;
		this.taxRate = taxRate;
		this.lowerBandCalculator = lowerBandCalculator;
	}
	
	@Override
	public long taxFor(long grossSalary) {
		return taxForBand(grossSalary) + taxForLowerBands(grossSalary);
	}

	private long taxForLowerBands(long grossSalary) {
		return lowerBandCalculator == null ? 0 : lowerBandCalculator.taxFor(grossToTaxAtLowerBand(grossSalary));
	}

	private long grossToTaxAtLowerBand(long grossSalary) {
		return Math.min(grossSalary, minimumGross);
	}

	private long taxForBand(long grossSalary) {
		return Math.round(grossInBand(grossSalary) * taxRate);
	}

	private long grossInBand(long grossSalary) {
		return Math.max(0, grossSalary - minimumGross);
	}
}
