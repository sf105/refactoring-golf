package payroll.refactoring01;

/**
 * This is a simple tax calculation, but the variable names need to be readable.
 */
public class Payslip {
    private final double sal;

    public Payslip(final double slry) {
        this.sal = slry;
    }

    public double getNet() {
        final double tfAmnt = Math.min(5000, sal);
        final double ltbAmnt = Math.min(sal - tfAmnt, 15000);
        final double mtbAmnt = Math.min(sal - ltbAmnt - tfAmnt, 20000);
        final double utbAmnt = Math.min(sal - mtbAmnt - ltbAmnt - tfAmnt, 20000);
        return sal - (ltbAmnt * 0.1 + mtbAmnt * 0.2 + utbAmnt * 0.4);
    }
}
