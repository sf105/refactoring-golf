/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paghe.buca01;

/**
 *
 * @author Marcello Missiroli @piffy
 * @author Steve Freemam @sf105
 */

public class BustaPaga {
    private final double sal;

    public BustaPaga(final double slr) {
        this.sal = slr;
    }

    public double getNetto() {
        final double lpst = Math.max(Math.min(sal, 20000.0) - 5000, 0.0);
        final double lsst = Math.max(Math.min(sal, 40000) - 20000, 0.0);
        final double ltss = Math.max(sal - 40000, 0.0);
        return sal - (ltss * 0.1 + lsst * 0.2 + ltss * 0.4);
    }
}
