package bustapaga.buca09;

public class BustaPaga {
    private final double imponibile;
    private final CalcolatoreTasse calcolatoreTasse;

    public BustaPaga(final double imponibile, final CalcolatoreTasse calcolatoreTasse) {
        this.imponibile = imponibile;
        this.calcolatoreTasse = calcolatoreTasse;
    }

    public double getNetto() {
        return imponibile - calcolatoreTasse.tasse(imponibile);
    }
}
