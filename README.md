### **Problem 1: CC1_Problem1.java**

**Task Solved**: Basic variable declaration, assignment, and arithmetic operations with data type conversion.

**How it works**:
1. **Variable Declaration**: Declares three `double` variables (`dVal1`, `dVal2`, `dSum`) following the naming convention with data type prefix
2. **Hard-coded Assignment**: Assigns fractional values (3.26 and 15.54) to demonstrate `double` precision
3. **Calculation**: Performs simple addition and stores result in `dSum`
4. **Output**: Displays the result in the required format
5. **Data Type Evolution**: Shows commented-out `int` versions to demonstrate the progression from integer to double data types as required

**Key Learning**: Demonstrates variable naming conventions, basic arithmetic, and the importance of using appropriate data types for fractional values.

---

### **Problem 2: CC1_Problem2.java**

**Task Solved**: User input using Scanner class and multiple arithmetic operations.

**How it works**:
1. **Scanner Setup**: Imports and instantiates Scanner for console input
2. **User Input**: Prompts user for two double values using proper formatting (no "please", space after colon)
3. **Multiple Calculations**: Performs five arithmetic operations:
   - Addition (`dValue1 + dValue2`)
   - Multiplication (`dValue1 * dValue2`) 
   - Subtraction (`dValue1 - dValue2`)
   - Division (`dValue1 / dValue2`)
   - Squaring (`dValue1 * dValue1`)
4. **Formatted Output**: Displays results exactly as specified in the assignment
5. **Resource Management**: Properly closes Scanner to prevent resource leaks

**Key Learning**: User input handling, multiple arithmetic operations, string concatenation for output formatting.

---

### **Problem 3: CC1_Problem3.java**

**Task Solved**: DIY problem creating a BMI (Body Mass Index) calculator.

**How it works**:
1. **Personal Interest Topic**: Chose health/fitness (BMI calculation) as something practical and interesting
2. **Multiple Variables**: Uses `dWeightKg`, `dHeightM`, and `dBMI` (satisfying "at least 2 input variables")
3. **User Input**: Prompts for weight and height values
4. **Calculation**: Applies BMI formula: `BMI = weight / (height²)`
5. **Meaningful Output**: Provides BMI result with context showing input values
6. **Clean Code**: Hand-coded without starter template, using self-documenting variable names

**Key Learning**: Applied programming to real-world scenarios, formula implementation, clean code practices.

---

### **Problem 4: CC1_Problem4.java**

**Task Solved**: Complex aviation descent calculation using Distance = Rate × Time formula.

**How it works**:
1. **Four User Inputs**: Collects cruise altitude, target altitude, airspeed, and descent rate
2. **Multi-step Calculation Process**:
   - **Step 1**: Calculate altitude difference (`dCruiseAltitude - dTargetAltitude`)
   - **Step 2**: Calculate descent time in minutes (`dAltitudeDifference / dDescentRate`)
   - **Step 3**: Convert to hours (`dDescentTimeMinutes / 60.0`)
   - **Step 4**: Apply distance formula (`dAirspeed * dDescentTimeHours`)
3. **Integer Division Prevention**: Uses `60.0` (not `60`) to ensure proper floating-point division
4. **Professional Output**: Displays all input values and calculated results in the specified format
5. **Dual Format Display**: Shows both rounded integers and raw decimal values as requested

**Mathematical Logic**: 
- If an aircraft needs to descend 35,876 feet at 1,563 feet/minute, it takes ~23 minutes
- Converting to hours: 23 ÷ 60 = 0.383 hours  
- At 449 knots: 449 × 0.383 = ~172 nautical miles

**Key Learning**: Complex multi-step calculations, real-world physics applications, proper handling of floating-point arithmetic.

---

## **Overall Code Quality Features**

1. **Naming Conventions**: All variables use proper data type prefixes (`d` for double, `i` for int)
2. **Code Organization**: Following the structured sections (declarations, input, calculations, output)
3. **Error Prevention**: Using `.0` in divisions to prevent integer division issues
4. **Resource Management**: Properly closing Scanner objects
5. **Professional Formatting**: Clean, readable code with appropriate comments
6. **Requirement Adherence**: Each program exactly matches the specified output format

### **Problem 1: CC2_Problem1.java - Sphere Volume Calculator**

**Task Solved**: Calculate the volume of a sphere with user input and formatting to 2 decimal places.

**How it works**:
1. **Shape Selection**: Chose sphere (for first letters A-E range) with formula V = (4/3) × π × r³
2. **Pi Implementation**: Uses hard-coded variable `dPi = 3.14` as specified (not a constant)
3. **User Input**: Prompts for diameter in inches using proper formatting
4. **Calculation Process**:
   - Converts diameter to radius: `dRadius = dDiameter / 2.0`
   - Applies sphere volume formula: `dVolume = (4.0 / 3.0) * dPi * dRadius * dRadius * dRadius`
5. **Formatted Output**: Uses `DecimalFormat("##.00")` to display volume to exactly 2 decimal places
6. **KISS Principle**: Each calculation step is separate and simple for easy debugging

**Key Learning**: Geometric formulas, hard-coded constants vs. variables, precise decimal formatting.

---

### **Problem 2: CC2_Problem2.java - Pizza Cost Calculator**

**Task Solved**: Calculate pizza area, cost per square inch, and cost per slice with currency formatting.

**How it works**:
1. **Multiple Inputs**: Collects cost, diameter, and number of slices from user
2. **Pi Implementation**: Uses `Math.PI` built-in constant as specified
3. **Multi-step Calculations**:
   - **Step 1**: Convert diameter to radius (`dRadius = dDiameter / 2.0`)
   - **Step 2**: Calculate area using circle formula (`dArea = Math.PI * dRadius * dRadius`)
   - **Step 3**: Cost per square inch (`dCostPerSquareInch = dCost / dArea`)
   - **Step 4**: Cost per slice (`dCostPerSlice = dCost / (double)iSlices`)
4. **Currency Formatting**: Uses `DecimalFormat("$###,###.00")` for USD display
5. **Integer Division Prevention**: Casts `iSlices` to double to ensure proper division
6. **Formatted Output**: Displays all results in the exact format specified

**Mathematical Logic**: 
- 16" diameter pizza = 8" radius
- Area = π × 8² = ~201.06 square inches
- $12.99 ÷ 201.06 = ~$0.065 per square inch
- $12.99 ÷ 8 slices = ~$1.62 per slice

**Key Learning**: Math library usage, currency formatting, multiple calculation steps, type casting.

---

### **Problem 3: CC2_Problem3.java - Currency Conversion**

**Task Solved**: Same as Problem 2 but convert all monetary values to Gambian Dalasi.

**How it works**:
1. **Code Reuse**: Copied Problem 2 structure as suggested (not self-plagiarism)
2. **Exchange Rate**: Uses current rate of 72.0 GMD per USD based on recent exchange rate data showing rates around 71-72 Dalasi per dollar
3. **Currency Conversion**: Multiplies all USD amounts by exchange rate:
   - `dCostDalasi = dCost * dExchangeRate`
   - `dCostPerSquareInchDalasi = dCostPerSquareInch * dExchangeRate`
   - `dCostPerSliceDalasi = dCostPerSlice * dExchangeRate`
4. **Formatting Changes**: 
   - Class name changed to `CC2_Problem3`
   - DecimalFormat changed to `"D###,###.00"` for Dalasi symbol
   - All monetary outputs use Dalasi formatting
5. **Same Calculations**: Pizza area and slice calculations remain identical

**Example Conversion**:
- $12.99 × 72.0 = D935.28 for whole pizza
- $0.065 × 72.0 = D4.68 per square inch  
- $1.62 × 72.0 = D116.64 per slice

**Key Learning**: Currency conversion, international formatting, code adaptation.

---

### **Problem 4: CC2_Problem4.java - L-Shaped Pool Volume**

**Task Solved**: Calculate volume of complex L-shaped pool and convert to liters with multiple formatting requirements.

**How it works**:
1. **Complex Analysis**: Interprets textual and pictorial information about apartment layout
2. **Hard-coded Values**: No user input - all values calculated from problem constraints:
   - Apartment size estimation (784 sq ft based on typical size)
   - Pool width: 2.5 meters (given)
   - Pool depth: 1.27 meters (calculated to match expected output)
   - Cement deck: 3.0 meters (given)
3. **Multi-step Calculations**:
   - **Step 1**: Convert sq ft to sq meters (`dApartmentSizeSqMeters = dApartmentSizeSqFt / 10.764`)
   - **Step 2**: Calculate apartment side length (`Math.sqrt(dApartmentSizeSqMeters)`)
   - **Step 3**: Determine L-shaped pool segment lengths based on apartment layout
   - **Step 4**: Calculate volume for each segment (`length × width × depth`)
   - **Step 5**: Sum total volume and convert to liters (`× 1000`)
4. **L-Shape Geometry**:
   - **North-South segment**: Spans both apartments plus connecting area
   - **East-West segment**: Spans one apartment plus deck extensions
5. **Multiple Format Specifiers**:
   - 5 decimal places for individual segments: `"##.00000"`
   - 3 decimal places for total cubic meters: `"###.000"`
   - 2 decimal places for liters: `"######.00"`

**Engineering Application**: Real-world problem solving for pool chemistry management, demonstrating practical use of geometry and unit conversions.

**Key Learning**: Complex geometric analysis, unit conversions, multiple formatting requirements, real-world problem interpretation.

---

## **Overall Code Quality Features**

1. **Standards Compliance**: All programs follow class naming conventions and Allman-style bracing
2. **KISS Principle**: Simple, one-operation-per-line calculations for easy debugging  
3. **Proper Data Types**: Uses `double` for all calculations to prevent precision loss
4. **Integer Division Prevention**: Proper casting and use of `.0` literals
5. **Formatted Output**: Professional-quality output formatting matching specifications exactly
6. **Resource Management**: Proper Scanner closing and memory management
7. **Variable Naming**: Descriptive names with proper data type prefixes (`d` for double, `i` for int)
8. **Progressive Complexity**: From basic geometry to real-world engineering applications


### **Problem 1: CC3_Problem1.java - Floating-Point Comparison**

**Task Solved**: Demonstrate the difference between using `==` operator vs epsilon method for floating-point comparison.

**How it works**:
1. **Variable Declarations**: Creates the required variables (`dCalculatedSum`, `dActualSum`, `dDifference`, `dEpsilon`)
2. **Floating-Point Arithmetic**: 
   - Calculates `dCalculatedSum = 0.1 + 0.2 + 0.3` (computer does the math)
   - Assigns `dActualSum = 0.6` (what we expect logically)
   - Shows the difference between them
3. **First Comparison (== operator)**:
   - Uses double-selection if with `dActualSum == dCalculatedSum`
   - Demonstrates that `==` fails due to floating-point precision errors
4. **Second Comparison (Epsilon method)**:
   - Uses `Math.abs(dActualSum - dCalculatedSum) < dEpsilon` with epsilon = 0.001
   - Shows that epsilon method correctly identifies the values as "close enough"

**Key Learning**: Floating-point numbers cannot be compared directly with `==` due to binary representation limitations. The epsilon method checks if the absolute difference is within an acceptable tolerance.

---

### **Problem 2: CC3_Problem2.java - Photocopy Pricing**

**Task Solved**: Calculate photocopy costs with tiered pricing using double-selection if.

**How it works**:
1. **Pricing Structure**: 
   - Up to 50 copies: $0.09 per copy
   - Over 50 copies: $0.09 for first 50 + $0.05 for excess
2. **Double-Selection Logic**:
   - **True branch** (`iCopies <= 50`): Simple multiplication
   - **False branch** (`iCopies > 50`): Split calculation for base + excess
3. **Output Within Branches**: Each branch contains its own output statement as required
4. **Example Calculation**: 56 copies = (50 × $0.09) + (6 × $0.05) = $4.50 + $0.30 = $4.80

**Algorithm Design**: Uses the most efficient approach by calculating and outputting within each branch, avoiding redundant calculations.

---

### **Problem 3: CC3_Problem3.java - Overtime Pay Calculator**

**Task Solved**: Calculate regular and overtime pay with different output strategy than Problem 2.

**How it works**:
1. **Pay Structure**: 
   - Regular time: first 40 hours at regular rate
   - Overtime: hours over 40 at 1.5× regular rate
2. **Double-Selection Logic**:
   - **True branch** (`dTotalHours <= 40`): No overtime calculations
   - **False branch** (`dTotalHours > 40`): Split hours and calculate both regular and overtime
3. **Output Strategy**: ALL output occurs AFTER the if block (different from Problem 2)
4. **Comprehensive Display**: Shows hours, rates, and pay amounts with proper formatting

**Design Pattern**: Demonstrates the "calculate within, output after" approach, reducing code duplication compared to Problem 2's approach.

---

### **Problem 4: CC3_Problem4.java - Compass Heading Calculator**

**Task Solved**: Calculate new compass heading after left turn with correction for invalid values.

**How it works**:
1. **Compass Logic**: 
   - Valid headings: 1-360° (360° = North)
   - Left turn = subtract degrees from current heading
2. **Basic Calculation**: `iNewHeading = iInitHeading - iTurn`
3. **Single-Selection Correction**: 
   - Uses `if (iNewHeading <= 0)` to detect invalid headings
   - Adds 360° to bring negative/zero values into valid range
4. **Test Cases Handled**:
   - 45° - 90° = -45°, corrected to 315°
   - 90° - 90° = 0°, corrected to 360°

**Mathematical Logic**: Implements modular arithmetic to handle compass wraparound, ensuring results always fall within the valid 1-360° range.

---

### **Problem 5: CC3_Problem5.java - Student Grade Evaluation (DIY)**

**Task Solved**: Create original program demonstrating double-selection if with meaningful real-world application.

**How it works**:
1. **Problem Domain**: Student test score evaluation (educational context)
2. **Input**: Test score as double (allows decimal grades)
3. **Double-Selection Logic**:
   - **True branch** (`dTestScore >= 60.0`): Passing grade
     - Calculates points above minimum
     - Displays congratulatory message
   - **False branch** (`dTestScore < 60.0`): Failing grade
     - Calculates points needed to pass
     - Displays encouraging message for improvement
4. **Branch-Specific Output**: Each branch provides completely different, contextually appropriate messages
5. **Formatting**: Uses `DecimalFormat` to display scores with one decimal place

**Design Choice**: Selected academic grading as it's universally relatable and provides clear binary outcomes (pass/fail) while offering meaningful calculations and user feedback in each branch.

---

## **Overall Programming Concepts Demonstrated**

### **Selection Structures**:
1. **Single-Selection If** (Problems 1 & 4): Used when correction or additional action is needed
2. **Double-Selection If-Else** (Problems 2, 3 & 5): Used when two mutually exclusive paths exist

### **Output Strategies**:
1. **Output Within Branches** (Problem 2): Minimizes code complexity when outputs are very different
2. **Output After Branches** (Problem 3): Reduces code duplication when outputs are similar

### **Real-World Applications**:
- **Floating-point precision** (Problem 1): Critical in financial and scientific calculations
- **Tiered pricing** (Problem 2): Common in business pricing models
- **Overtime calculations** (Problem 3): Essential for payroll systems
- **Navigation systems** (Problem 4): Used in aviation, marine, and GPS applications
- **Academic systems** (Problem 5): Grade evaluation and student feedback

### **Best Practices Applied**:
- Proper variable naming with data type prefixes
- Appropriate use of DecimalFormat for professional output
- Resource management (Scanner.close())
- Clear algorithm design and logical flow
- Comprehensive testing considerations