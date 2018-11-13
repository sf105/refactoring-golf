package payroll.hole03;

public class Payslip {
    private final double grossSalary;

    public Payslip(final double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNet() {
        return grossSalary - calculatedTax();
    }

    private double calculatedTax() {
        final double lowerTaxBracketGross = Math.max(Math.min(grossSalary, 20000.0) - 5000, 0.0);
        final double middleTaxBracketGross = Math.max(Math.min(grossSalary, 40000) - 20000, 0.0);
        final double upperTaxBracketGross = Math.max(grossSalary - 40000, 0.0);
        return lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4;
    }
}
