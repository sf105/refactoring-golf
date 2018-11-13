package payroll.hole01;

public class Payslip {
    private final double sal;

    public Payslip(final double slry) {
        this.sal = slry;
    }

    public double getNet() {
        final double ltbg = Math.max(Math.min(sal, 20000.0) - 5000, 0.0);
        final double mtbg = Math.max(Math.min(sal, 40000) - 20000, 0.0);
        final double utbg = Math.max(sal - 40000, 0.0);
        return sal - (ltbg * 0.1 + mtbg * 0.2 + utbg * 0.4);
    }
}
