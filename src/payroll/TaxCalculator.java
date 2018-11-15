package payroll;

import java.util.stream.Stream;

import static payroll.TaxBand.NIL_TAX_BAND;

public class TaxCalculator {
    private final TaxBand lowerTaxBand = new TaxBand.ChainedTaxBand(0.1, 5000, 1500, NIL_TAX_BAND);
    private final TaxBand middleTaxBand = new TaxBand.ChainedTaxBand(0.2, 20000, 4000, lowerTaxBand);
    private final TaxBand upperTaxBand = new TaxBand.ChainedTaxBand(0.4, 40000, 0, middleTaxBand);
    private final Stream<TaxBand> taxBands = Stream.of(upperTaxBand, middleTaxBand, lowerTaxBand);

    public long taxFor(long grossSalary) {
        return taxBandFor(grossSalary).taxFor(grossSalary);
    }

    private TaxBand taxBandFor(long grossSalary) {
        return taxBands.filter(taxBand -> taxBand.appliesTo(grossSalary)).findFirst().orElse(NIL_TAX_BAND);
    }
}
