# How Each Solution Works:

## Problem 1 (Charts):

- Uses DITM (Declare, Initialize, Test, Manage) for while loop
- Implements input validation to ensure start < end values
- While loop for sodium chloride solution calculation (3% = 0.03 ratio)
- For loop for ounces to milliliters conversion (1 oz = 29.5735 ml)

## Problem 2 (4-Item Register):

- Counter-controlled while loop with exactly 4 iterations
- Accumulates subtotal using addition
- Calculates 6% sales tax and total
- Uses proper currency formatting

## Problem 3 (Unlimited Items):

- Sentinel-controlled while loop (negative cost terminates)
- Handles edge case of no items entered
- Counts items and accumulates total
- Same tax and total calculations as Problem 2

## Problem 4 (Acronym Builder):

- Uses Scanner.nextLine() for full phrase input
- Tokenizes string using Scanner.hasNext() and Scanner.next()
- Extracts first letter using substring(0,1)
- Includes option to skip minor words (of, for, and, by, with)
- Proper input validation for empty strings

## Problem 5 (Compound Interest):

- Comprehensive input validation for all numeric inputs
- Uses compound interest formula: A = P(1 + r/n)^nt
- Displays period-by-period chart showing balance growth
- Includes summary with total interest earned and return percentage
- Proper currency and percentage formatting

Each solution follows the class standards with proper variable naming (data-type prefixes), Allman-style bracing, and clear section organization.
        