package payroll.hole08;

public class TaxCalculator {
    public double taxFor(final double grossSalary) {
		final TaxBand lowerTaxBand = new TaxBand(5000.0, 0.1, null);
		final TaxBand middleTaxBand = new TaxBand(20000.0, 0.2, lowerTaxBand);
		final TaxBand upperTaxBand = new TaxBand(40000.0, 0.4, middleTaxBand);

		return upperTaxBand.taxFor(grossSalary);
    }

	private static class TaxBand {
		private final double minimumGross;
		private final double taxRate;
		private final TaxBand lowerTaxBand;

		private TaxBand(double minimumGross, double taxRate, TaxBand lowerTaxBand) {
			this.minimumGross = minimumGross;
			this.taxRate = taxRate;
			this.lowerTaxBand = lowerTaxBand;
		}

		private double grossInBand(double grossSalary) {
			return Math.max(0, grossSalary - minimumGross);
		}

		private double grossToTaxAtLowerBand(final double grossSalary) {
			return Math.min(grossSalary, minimumGross);
		}

		private double taxForBand(final double grossSalary) {
			return grossInBand(grossSalary) * taxRate;
		}

		private double taxForLowerBands(double grossSalary) {
			return lowerTaxBand == null ? 0 : lowerTaxBand.taxFor(grossToTaxAtLowerBand(grossSalary));
		}

		private double taxFor(double grossSalary) {
			return taxForBand(grossSalary) + taxForLowerBands(grossSalary);
		}
	}
}
