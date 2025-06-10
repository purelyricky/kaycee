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