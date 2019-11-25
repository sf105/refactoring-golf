package bustapaga.buca10;

public class CalcolatoreScaglioneTasse implements CalcolatoreTasse {
	private final double minimumGross;
	private final double taxRate;
	private final CalcolatoreTasse lowerBandCalculator;

	public CalcolatoreScaglioneTasse(double minimumGross, double taxRate, CalcolatoreTasse lowerBandCalculator) {
		this.minimumGross = minimumGross;
		this.taxRate = taxRate;
		this.lowerBandCalculator = lowerBandCalculator;
	}
	
	@Override
	public double tasse(double grossSalary) {
		return taxForBand(grossSalary) + getTaxForLowerBands(grossSalary);
	}

	private double getTaxForLowerBands(double grossSalary) {
		return lowerBandCalculator.tasse(grossToTaxAtLowerBand(grossSalary));
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
