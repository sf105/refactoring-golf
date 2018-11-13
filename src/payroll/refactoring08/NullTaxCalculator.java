package payroll.refactoring08;

public class NullTaxCalculator implements TaxCalculator {
	@Override
	public double taxFor(double grossSalary) {
		return 0;
	}
}
