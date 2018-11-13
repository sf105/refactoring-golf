package payroll.refactoring03;

/**
 *  Payslip knows too much about tax calculations
 */
public class Payslip {
    private final double grossSalary;

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNet() {
        return grossSalary - getTax();
    }

    private double getTax() {
        final double taxFreeGross = Math.min(5000, grossSalary);
        final double lowerTaxBracketGross = Math.min(grossSalary - taxFreeGross, 15000);
        final double middleTaxBracketGross = Math.min(grossSalary - lowerTaxBracketGross - taxFreeGross, 20000);
        final double upperTaxBracketGross = Math.min(grossSalary - middleTaxBracketGross - lowerTaxBracketGross - taxFreeGross, 20000);
        return lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4;
    }
}
