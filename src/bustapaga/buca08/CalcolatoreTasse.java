package bustapaga.buca08;

public class CalcolatoreTasse {
    public double tasse(final double imponibile) {
		final Scaglione primoScaglione = new Scaglione(5000.0, 0.1, null);
		final Scaglione secondoScaglione = new Scaglione(20000.0, 0.2, primoScaglione);
		final Scaglione terzoScaglione = new Scaglione(40000.0, 0.4, secondoScaglione);

		return terzoScaglione.tasse(imponibile);
    }

	private static class Scaglione {
		private final double imponibileMinimo;
		private final double percentuale;
		private final Scaglione scaglioneInferiore;

		private Scaglione(double imponibileMinimo, double percentuale, Scaglione scaglioneInferiore) {
			this.imponibileMinimo = imponibileMinimo;
			this.percentuale = percentuale;
			this.scaglioneInferiore = scaglioneInferiore;
		}

		private double imponibileDelloScaglione(double imponibile) {
			return Math.max(0, imponibile - imponibileMinimo);
		}

		private double imponibileDaTassareNegliAltriScaglioni(final double imponibile) {
			return Math.min(imponibile, imponibileMinimo);
		}

		private double tasseDelloScaglione(final double imponibile) {
			return imponibileDelloScaglione(imponibile) * percentuale;
		}

		private double tasseDegliScaglioniInferiori(double imponibile) {
			return scaglioneInferiore == null ? 0 : scaglioneInferiore.tasse(imponibileDaTassareNegliAltriScaglioni(imponibile));
		}

		private double tasse(double grossSalary) {
			return tasseDelloScaglione(grossSalary) + tasseDegliScaglioniInferiori(grossSalary);
		}
	}
}
