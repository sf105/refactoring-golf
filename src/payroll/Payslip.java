package payroll;

public class Payslip {
    private final long grossSalary;

    public Payslip(long grossSalary) {
        this.grossSalary = grossSalary;
    }

    public long netSalary() {
        return grossSalary - taxFor();
    }

    private long taxFor() {
        long tax = 0;

        if (grossSalary > 5000) {
            tax = Math.round((grossSalary - 5000) * 0.1);
        }

        if (grossSalary > 20000) {
            tax = 1500 + Math.round((grossSalary - 20000) * 0.2);
        }

        if (grossSalary > 40000) {
           tax =  1500 + 4000 + Math.round((grossSalary - 40000) * 0.4);
        }
        return tax;
    }
}
