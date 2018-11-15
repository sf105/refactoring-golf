package payroll.hole10;

public class BandedTaxCalculator implements TaxCalculator {
	private final double minimumGross;
	private final double taxRate;
	private final TaxCalculator lowerBandCalculator;

	public BandedTaxCalculator(double minimumGross, double taxRate, TaxCalculator lowerBandCalculator) {
		this.minimumGross = minimumGross;
		this.taxRate = taxRate;
		this.lowerBandCalculator = lowerBandCalculator;
	}
	
	@Override
	public double taxFor(double grossSalary) {
		return taxForBand(grossSalary) + getTaxForLowerBands(grossSalary);
	}

	private double getTaxForLowerBands(double grossSalary) {
		return lowerBandCalculator.taxFor(grossToTaxAtLowerBand(grossSalary));
	}

	private double grossToTaxAtLowerBand(double grossSalary) {
		return Math.min(grossSalary, minimumGross);
	}

	private double taxForBand(double grossSalary) {
		return grossInBand(grossSalary) * taxRate;
	}

	private double grossInBand(double grossSalary) {
		return Math.max(0, grossSalary - minimumGross);
	}
}
