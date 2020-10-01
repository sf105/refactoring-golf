package bustapaga.buca06;

public class CalcolatoreTasse {
    public double per(final double imponibile) {
        final double inizioTerzoScaglione = 40000;
        final double percentualeTerzoScaglione = 0.4;
		final double tasseTerzoScaglione = tasseDelloScaglione(imponibile, inizioTerzoScaglione, percentualeTerzoScaglione);
        final double imponibileResiduoPerGliScaglioniInferiori = imponibileResiduoDaTassare(imponibile, inizioTerzoScaglione);
        
        final double inizioSecondoScaglione = 20000;
        final double percentualeSecondoScaglione = 0.2;
		final double tasseSecondoScaglione = tasseDelloScaglione(imponibileResiduoPerGliScaglioniInferiori, inizioSecondoScaglione, percentualeSecondoScaglione);
        final double imponibileRimanenentePerPrimoScaglione = imponibileResiduoDaTassare(imponibileResiduoPerGliScaglioniInferiori, inizioSecondoScaglione);
        
        final double inizioPrimoScaglione = 5000;
        final double percentualePrimoScaglione = 0.1;
		final double tassePrimoScaglione = tasseDelloScaglione(imponibileRimanenentePerPrimoScaglione, inizioPrimoScaglione, percentualePrimoScaglione);
        
		return tassePrimoScaglione + tasseSecondoScaglione + tasseTerzoScaglione;
    }

	private double tasseDelloScaglione(final double imponibileEsclusoPartiGiàTassate, final double imponibileMinimoScaglione, final double percentuale) {
		return imponibileDaTassareNelloScaglione(imponibileEsclusoPartiGiàTassate, imponibileMinimoScaglione) * percentuale;
	}

	private double imponibileResiduoDaTassare(final double imponibile, final double imponibileMinimoScaglione) {
		return Math.min(imponibile, imponibileMinimoScaglione);
	}

	private double imponibileDaTassareNelloScaglione(double imponibileEsclusoPartiGiàTassate, final double imponibileMinimoScaglione) {
		return Math.max(0, imponibileEsclusoPartiGiàTassate - imponibileMinimoScaglione);
	}
}
