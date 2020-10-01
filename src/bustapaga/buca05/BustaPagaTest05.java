package bustapaga.buca05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BustaPagaTest05 {
    @Test
    public void tasseZeroSeImponibileInferioreAlPrimoScaglione() {
        assertNettoDatoIlLordo(5000, 5000);
    }

    @Test
    public void tasseDelPrimoScaglioneEsclusoZonaEsentasse() {
        assertNettoDatoIlLordo(10000, 9500);
        assertNettoDatoIlLordo(20000, 18500);
    }

    @Test
    public void tasseDelSecondoScaglioneComeSommaDelleTasseDelPrimoScaglioneEDelSecondoScaglione() {
        assertNettoDatoIlLordo(25000, 22500);
        assertNettoDatoIlLordo(40000, 34500);
    }

    @Test
    public void tasseDelTerzoScaglioneComeSommaDelleTasseDiTuttiGliScaglioni() {
        assertNettoDatoIlLordo(50000, 40500);
        assertNettoDatoIlLordo(60000, 46500);
    }

    private void assertNettoDatoIlLordo(final int lordo, final int nettoAtteso) {
        final BustaPaga bustaPaga = new BustaPaga(lordo, new CalcolatoreTasse());
        assertEquals(nettoAtteso, bustaPaga.getNetto(), 1e-6);
    }
}
