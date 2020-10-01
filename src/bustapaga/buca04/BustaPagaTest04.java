package bustapaga.buca04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BustaPagaTest04 {
    @Test
    public void tasseZeroSeImponibileInferioreAlPrimoScaglione() {
        BustaPaga bustaPaga = new BustaPaga(5000, new CalcolatoreTasse());
        assertEquals(5000, bustaPaga.getNetto(), 1e-6);
    }

    @Test
    public void tasseDelPrimoScaglioneEsclusoZonaEsentasse() {
        final BustaPaga bustaPaga = new BustaPaga(10000, new CalcolatoreTasse());
        assertEquals(9500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(20000, new CalcolatoreTasse());
        assertEquals(18500, bustaPaga2.getNetto(), 1e-6);
    }

    @Test
    public void tasseDelSecondoScaglioneComeSommaDelleTasseDelPrimoScaglioneEDelSecondoScaglione() {
        final BustaPaga bustaPaga = new BustaPaga(25000, new CalcolatoreTasse());
        assertEquals(22500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(40000, new CalcolatoreTasse());
        assertEquals(34500, bustaPaga2.getNetto(), 1e-6);
    }

    @Test
    public void tasseDelTerzoScaglioneComeSommaDelleTasseDiTuttiGliScaglioni() {
        final BustaPaga bustaPaga = new BustaPaga(50000, new CalcolatoreTasse());
        assertEquals(40500, bustaPaga.getNetto(), 1e-6);

        final BustaPaga bustaPaga2 = new BustaPaga(60000, new CalcolatoreTasse());
        assertEquals(46500, bustaPaga2.getNetto(), 1e-6);
    }
}