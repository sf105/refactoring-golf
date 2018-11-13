package payroll.refactoring08;

public class NullTaxCalculator implements TaxCalculator {
	@Override
	public double getTax(double grossSalary) {
		return 0;
	}
}
