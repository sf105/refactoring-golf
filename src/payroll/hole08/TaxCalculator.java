package payroll.hole08;

public class TaxCalculator {
    public long taxFor(final long grossSalary) {
		final TaxBand lowerTaxBand = new TaxBand(5000, 0.1, null);
		final TaxBand middleTaxBand = new TaxBand(20000, 0.2, lowerTaxBand);
		final TaxBand upperTaxBand = new TaxBand(40000, 0.4, middleTaxBand);

		return upperTaxBand.taxFor(grossSalary);
    }

	private static class TaxBand {
		private final long minimumGross;
		private final double taxRate;
		private final TaxBand lowerTaxBand;

		private TaxBand(long minimumGross, double taxRate, TaxBand lowerTaxBand) {
			this.minimumGross = minimumGross;
			this.taxRate = taxRate;
			this.lowerTaxBand = lowerTaxBand;
		}

		private long grossInBand(long grossSalary) {
			return Math.max(0, grossSalary - minimumGross);
		}

		private long grossToTaxAtLowerBand(final long grossSalary) {
			return Math.min(grossSalary, minimumGross);
		}

		private long taxForBand(final long grossSalary) {
			return Math.round(grossInBand(grossSalary) * taxRate);
		}

		private long taxForLowerBands(long grossSalary) {
			return lowerTaxBand == null ? 0 : lowerTaxBand.taxFor(grossToTaxAtLowerBand(grossSalary));
		}

		private long taxFor(long grossSalary) {
			return taxForBand(grossSalary) + taxForLowerBands(grossSalary);
		}
	}
}
