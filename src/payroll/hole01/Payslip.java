package payroll.hole01;

public class Payslip {
    private final long sal;

    public Payslip(final long slry) {
        this.sal = slry;
    }

    public long getNet() {
        final long ltbg = Math.max(Math.min(sal, 20000) - 5000, 0);
        final long mtbg = Math.max(Math.min(sal, 40000) - 20000, 0);
        final long utbg = Math.max(sal - 40000, 0);
        return Math.round(sal - (ltbg * 0.1 + mtbg * 0.2 + utbg * 0.4));
    }
}
