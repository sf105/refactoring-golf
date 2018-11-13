package payroll.refactoring09;

public class NullTaxCalculator implements TaxCalculator {
	@Override
	public double taxFor(double grossSalary) {
		return 0;
	}
}
