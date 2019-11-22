package bustapaga.buca07;

public class CalcolatoreTasse {
    public double tasse(final double imponibile) {
		final Scaglione terzoScaglione = new Scaglione(40000.0, 0.4);
		final double tasseTerzoScaglione = terzoScaglione.tasseDelloScaglione(imponibile);
        final double imponibileResiduoPerGliScaglioniInferiori = terzoScaglione.imponibileResiduoDaTassare(imponibile);

		final Scaglione secondoScaglione = new Scaglione(20000.0, 0.2);
		final double tasseSecondoScaglione = secondoScaglione.tasseDelloScaglione(imponibileResiduoPerGliScaglioniInferiori);
        final double imponibileResiduoPerIlPrimoScaglione = secondoScaglione.imponibileResiduoDaTassare(imponibileResiduoPerGliScaglioniInferiori);

		final Scaglione primoScaglione = new Scaglione(5000.0, 0.1);
		final double tassePrimoScaglione = primoScaglione.tasseDelloScaglione(imponibileResiduoPerIlPrimoScaglione);
        
		return tassePrimoScaglione + tasseSecondoScaglione + tasseTerzoScaglione;
    }

	private static class Scaglione {
		private final double imponibileMinimo;
		private final double percentuale;

		private Scaglione(double imponibileMinimo, double percentuale) {
			this.imponibileMinimo = imponibileMinimo;
			this.percentuale = percentuale;
		}

		private double imponibileDaTassareNelloScaglione(double imponibileEsclusoPartiGiàTassate) {
			return Math.max(0, imponibileEsclusoPartiGiàTassate - imponibileMinimo);
		}

		private double imponibileResiduoDaTassare(final double imponibile) {
			return Math.min(imponibile, imponibileMinimo);
		}

		private double tasseDelloScaglione(final double imponibileEsclusoPartiGiàTassate) {
			return imponibileDaTassareNelloScaglione(imponibileEsclusoPartiGiàTassate) * percentuale;
		}
	}
}
