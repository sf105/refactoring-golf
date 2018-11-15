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
- Extract variable for tax bracket rates (x3)
- extract variable for tax bracket starts (x3)
- extract remaining gross for middle and lower brackets (x2)
- extract grossToTaxInBandsBelowCurrent() (IDE promts for a duplicate)
- extract taxInBand() (IDE prompts for 2 duplicates)
- rename parameter to grossSalaryExcludingPartAlreadyTaxedAtHigherRate
- extract grossToTaxInBand
- inline upperTaxBracketGross

Refactoring 6
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

Refactoring 07
- order lower/middle/upper tax bands
- Add middleTaxBand to upperTaxBandConstructor (1 x2)
- Create constructor (Default null, use any var)
- Assign to field
- extract taxForLowerBands(lower, middle)
- move taxForLowerBands to middleTaxBand
- use this.lowerTaxBand instead of parameter
- remove unused parameter
- rename remainingGrossForMiddleAndLowerBrackets to grossSalary
- rename grossToTaxInBandsBelowCurrent to grossToTaxAtLowerBand
- rename grossToTaxInBand to grossInBand
- rename grossSalaryExcludingPartAlreadyTaxedAtHigherRate to grossSalary
- rename taxInBand to taxForBand
- rename grossSalaryExcludingPartAlreadyTaxedAtHigherRate to grossSalary
- extract variable lowerMiddleTax
- extract method taxFor (lowerMiddleTax)
- move taxFor to TaxBand
- rename remainingGrossForMiddleAndLowerBrackets to grossSalary
- inline low and middle bracket tax (x2)
- inline remainingGrossForLowerBracket
- replace taxForBand with taxFor within taxForLowerBands (failing test) 2x2
- null check (2)
- replace body of TaxCalculator.taxFor with upperTaxBand.taxFor()

Refactoring 08
- extract TaxCalculator as interface (TaxCalculatorTemp)
- make TaxBand.taxFor public 
- move TaxBand up to top level and rename to BandedTaxCalculator
- rename lowerTaxBand to lowerBandCalculator
- implement TaxCalculator (2)
- move calculators from TaxCalculatorTemp to test
- delete TaxCalculatorTemp
