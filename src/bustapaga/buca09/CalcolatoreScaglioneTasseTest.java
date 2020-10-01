package bustapaga.buca09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcolatoreScaglioneTasseTest {
	private static final double PERCENTUALE_SCAGLIONE = 0.1;
	private static final int IMPONIBILE_MINIMO_SCAGLIONE = 1000;
	private static final int TASSE_SCAGLIONE_INFERIORE = 1;
	
	private CalcolatoreScaglioneTasse calculator = new CalcolatoreScaglioneTasse(IMPONIBILE_MINIMO_SCAGLIONE, PERCENTUALE_SCAGLIONE, new CalcolatoreTasse() {
		@Override
		public double tasse(double imponibile) {
			return TASSE_SCAGLIONE_INFERIORE;
		}
	});


	@Test
	public void tasseDelloScaglioneInferioreÈZeroSeIlCalcolatoreInferioreÈNull() {
		CalcolatoreScaglioneTasse calculator = new CalcolatoreScaglioneTasse(IMPONIBILE_MINIMO_SCAGLIONE, PERCENTUALE_SCAGLIONE, null);
		assertEquals(PERCENTUALE_SCAGLIONE * (2000 - IMPONIBILE_MINIMO_SCAGLIONE), calculator.tasse(2000), 0);
	}

	@Test
	public void tutteLeTasseDerivanDagliScaglioniInferioriSeImponibileMinoreDelMinimoDelloScaglione() {
		assertEquals(TASSE_SCAGLIONE_INFERIORE, calculator.tasse(IMPONIBILE_MINIMO_SCAGLIONE), 0);
	}
	
	@Test
	public void leTasseSonoLaSommaDelleTasseDegliScaglioniInferiorIEDiQuestoScaglione() {
		assertEquals(TASSE_SCAGLIONE_INFERIORE + PERCENTUALE_SCAGLIONE * (2000 - IMPONIBILE_MINIMO_SCAGLIONE), calculator.tasse(2000), 0);
	}
}
