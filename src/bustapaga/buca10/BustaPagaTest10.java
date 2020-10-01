package bustapaga.buca10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BustaPagaTest10 {
    @Test
    public void nettoÈImponibileMenoTasse() {
        final BustaPaga bustaPaga = new BustaPaga(5000, imponibile -> 500);
        assertEquals(4500, bustaPaga.getNetto(), 1e-6);
    }
}
