package payroll.hole10;

public class NullTaxCalculator implements TaxCalculator {
	@Override
	public double taxFor(double grossSalary) {
		return 0;
	}
}
