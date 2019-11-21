package bustapaga.buca01;

public class BustaPaga {
    private final double stip;

    public BustaPaga(final double stpnd) {
        this.stip = stpnd;
    }

    public double getNetto() {
        final double pst = Math.max(Math.min(stip, 20000.0) - 5000, 0.0);
        final double sst = Math.max(Math.min(stip, 40000) - 20000, 0.0);
        final double tst = Math.max(stip - 40000, 0.0);
        return stip - (pst * 0.1 + sst * 0.2 + tst * 0.4);
    }
}
