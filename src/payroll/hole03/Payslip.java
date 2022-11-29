package payroll.hole03;

public class Payslip {
    private final long grossSalary;

    public Payslip(final long grossSalary) {
        this.grossSalary = grossSalary;
    }

    public long getNet() {
        return grossSalary - calculatedTax();
    }

    private long calculatedTax() {
        final long lowerTaxBracketGross = Math.max(Math.min(grossSalary, 20000) - 5000, 0);
        final long middleTaxBracketGross = Math.max(Math.min(grossSalary, 40000) - 20000, 0);
        final long upperTaxBracketGross = Math.max(grossSalary - 40000, 0);
        return Math.round(lowerTaxBracketGross * 0.1 + middleTaxBracketGross * 0.2 + upperTaxBracketGross * 0.4);
    }
}
