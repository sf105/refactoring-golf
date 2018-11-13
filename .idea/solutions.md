Refactoring 1
- rename 6 variables. 6 points.

Refactoring 2
- extract local variable tax 
- extract method calculatedTax()
- inline local variable tax in getNet()

Refactoring 3
- extract MethodObject to create TaxCalculator
- inline generate invoke() method
- in calculatedTax, IntroduceParameter grossSalary
- convert TaxCalculator() to field, initialised in Constructor
- make TaxCalculator static
- introduce taxCalculator parameter to constructor
- rename calculatedTax to taxFor
- change scope of taxFor to public
- move TaxCalculator to top level

Refactoring 4
- extract method assertNetForGross
- introduce parameter netSalary
- fix tests manually
- move assertNetForGross to bottom

Refactoring 5
- Extract ParameterObject with bracketMinimumGross and taxRate
- change signature to add taxBand parameter to getGrossToTaxInBand
- reference bracketMinimumGross from taxBand
- remove unused parameter
- move getGrossToTaxInBand to TaxBand
- extract variables for TaxBands
- add TaxBand parameter to getGrossToTaxInBandsBelowCurrent
- use bracketMinimumGross from taxBand parameter
- remove unused bracketMinimumGross
- move getGrossToTaxInBandsBelowCurrent to TaxBand
- remove unused getBracketMinimumGross
- move getTaxInBand to TaxBand
- inline getTaxRate
- inline tax band constants
