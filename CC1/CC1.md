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
