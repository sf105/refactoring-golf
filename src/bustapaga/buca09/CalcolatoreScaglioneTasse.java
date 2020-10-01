package bustapaga.buca09;


public class CalcolatoreScaglioneTasse implements CalcolatoreTasse {
	private final double imponibileMinimo;
	private final double percentuale;
	private final CalcolatoreTasse calcolatoreScaglioneInferiore;



	public CalcolatoreScaglioneTasse(double imponibileMinimo, double percentuale, CalcolatoreTasse calcolatoreScaglioneInferiore) {
		this.imponibileMinimo = imponibileMinimo;
		this.percentuale = percentuale;
		this.calcolatoreScaglioneInferiore = calcolatoreScaglioneInferiore;
	}
	
	@Override
	public double tasse(double imponibile) {
		return tasseDelloScaglione(imponibile) + taxForLowerBands(imponibile);
	}

	private double taxForLowerBands(double imponibile) {
		return calcolatoreScaglioneInferiore == null ? 0 : calcolatoreScaglioneInferiore.tasse(imponibileDaTassareNegliAltriScaglioni(imponibile));
	}

	private double imponibileDaTassareNegliAltriScaglioni(double imponibile) {
		return Math.min(imponibile, imponibileMinimo);
	}

	private double tasseDelloScaglione(double imponibile) {
		return imponibileDelloScaglione(imponibile) * percentuale;
	}

	private double imponibileDelloScaglione(double imponibile) {
		return Math.max(0, imponibile - imponibileMinimo);
	}
}
