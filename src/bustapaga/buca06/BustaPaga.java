package bustapaga.buca06;

public class BustaPaga {
    private final double imponibile;
    private final CalcolatoreTasse calcolatoreTasse;

    public BustaPaga(final double imponibile, final CalcolatoreTasse calcolatoreTasse) {
        this.imponibile = imponibile;
        this.calcolatoreTasse = calcolatoreTasse;
    }

    public double getNetto() {
        return imponibile - calcolatoreTasse.per(imponibile);
    }
}