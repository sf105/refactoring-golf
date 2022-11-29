package payroll.hole10;

public class NullTaxCalculator implements TaxCalculator {
	@Override
	public long taxFor(long grossSalary) {
		return 0;
	}
}
