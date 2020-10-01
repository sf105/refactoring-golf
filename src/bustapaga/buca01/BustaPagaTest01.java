package bustapaga.buca01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BustaPagaTest01 {
    @Test
    public void tasseZeroSeImponibileInferioreAlPrimoScaglione() {
        BustaPaga bustaPaga = new BustaPaga(5000);
        assertEquals(5000, bustaPaga.getNetto(), 1e-6);
    }

    @Test
    public void tasseDelPrimoScaglioneEsclusoZonaEsentasse() {
        final BustaPaga bustaPaga = new BustaPaga(10000);
        assertEquals(9500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(20000);
        assertEquals(18500, bustaPaga2.getNetto(), 1e-6);
    }

    @Test
    public void tasseDelSecondoScaglioneComeSommaDelleTasseDelPrimoScaglioneEDelSecondoScaglione() {
        final BustaPaga bustaPaga = new BustaPaga(25000);
        assertEquals(22500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(40000);
        assertEquals(34500, bustaPaga2.getNetto(), 1e-6);
    }

    @Test
    public void tasseDelTerzoScaglioneComeSommaDelleTasseDiTuttiGliScaglioni() {
        final BustaPaga bustaPaga = new BustaPaga(50000);
        assertEquals(40500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(60000);
        assertEquals(46500, bustaPaga2.getNetto(), 1e-6);
    }
}
