### **Problem 1: CC4_Problem1.java - Email Validation with Composite Error String Builder**

**Task Solved**: Validate email addresses using a composite error string builder technique with 4 different validation tests.

**How it works**:
1. **Composite Error String**: Starts with empty string `sErrMsg = ""`
2. **Four Validation Tests Chosen**:
   - **Length validation**: 5-320 characters (prevents obviously invalid entries)
   - **Single @ symbol**: Finds first @, then checks if substring after it contains another @
   - **Local part length**: Extracts characters before @ and validates ≤64 characters
   - **Top-level domain**: Validates against approved domains (.com, .org, .net, .edu, .gov, .tv, .mx)

3. **Error Accumulation**: Each failed test appends error message + carriage return (char 13) + line feed (char 10)
4. **String Methods Used**:
   - `indexOf("@")` to find @ position
   - `substring()` to extract local and domain parts
   - `contains()` to check for additional @ symbols
   - `endsWith()` to validate top-level domains
   - `equals("")` to check if error string is empty

**Key Learning**: Demonstrates composite error handling, String manipulation methods, and comprehensive input validation.

---

### **Problem 2: CC4_Problem2.java - Nested Grade Calculator**

**Task Solved**: Validate numeric scores and assign letter grades using nested if structure with efficient "drop-through" logic.

**How it works**:
1. **Outer If Validation**: Checks if score is in valid range (0-100)
   - Invalid range → displays error and stops
   - Valid range → proceeds to grade assignment
2. **Inner Multiple-Selection If**: Uses efficient drop-through logic
   - No redundant upper bounds (e.g., NOT `>= 80 && < 90`)
   - Relies on logical flow: if not ≥90, then must be <90
3. **Grade Scale**: Implements +/- grading system:
   - A (93-100), A- (90-92), B+ (87-89), B (83-86), etc.
4. **Efficiency**: Single pass through conditions, minimal comparisons

**Algorithm Advantage**: Demonstrates proper nested validation and efficient conditional logic without redundant range checks.

---

### **Problem 3: CC4_Problem3.java - DC SFRA Gate Selection**

**Task Solved**: Select appropriate aviation gate and radio frequency based on compass radial for Washington DC Special Flight Rules Area.

**Relationship to PDF**: The PDF document provides the critical gate/frequency mapping table on page 2.

**How it works**:
1. **Data Source**: Uses Entry/Exit Filing Gates table from PDF:
   - WOOLY (132.775): Radials 341-360 and 1-46 (wraps around north)
   - PALEO (132.775): Radials 47-119
   - WHINO (125.125): Radials 120-172
   - GRUBY (125.125): Radials 173-214
   - BRV (127.325): Radials 215-236
   - FLUKY (127.325): Radials 237-269
   - JASEN (127.325): Radials 270-309
   - LUCKE (127.325): Radials 310-340

2. **Special Case Handling**: WOOLY gate handles compass wraparound (341-360 OR 1-46)
3. **Input Validation**: Ensures radial is in valid range (1-360)
4. **Multiple Selection**: Uses if-else if structure for efficient gate determination

**Real-World Application**: Critical for aviation safety in restricted airspace around Washington DC.

---

### **Problem 4: CC4_Problem4.java - McCormick Focus Group Eligibility**

**Task Solved**: Determine eligibility for paid focus group using three-level nested if structure with early termination.

**How it works**:
1. **Three-Level Nesting**:
   - **Level 1**: Available on April 1? (Y/N)
   - **Level 2**: 18 or older? (Y/N) - only asked if Level 1 = Y
   - **Level 3**: Married? (Y/N) - only asked if Level 2 = Y

2. **Early Termination Logic**: Once user answers "N", questioning stops
3. **Input Validation**: Each level handles three cases:
   - "Y" → proceed to next level
   - "N" → display "not eligible" and stop
   - Invalid → display error and stop

4. **String Processing**:
   - Uses `cin.next()` for single-word input
   - `toUpperCase()` for case-insensitive comparison
   - `.equals()` method for String comparison (not ==)

**Design Pattern**: Demonstrates efficient nested validation with early exit strategy.

---

### **Problem 5: CC4_Problem5.java - Career Change Counseling (DIY)**

**Task Solved**: Create original nested decision tree for career counseling (T-Z category: career matters).

**How it works**:
1. **Problem Domain**: Career change decision support system
2. **Three-Level Decision Tree**:
   - **Level 1**: Job satisfaction - "Are you unhappy in your current job?"
   - **Level 2**: Financial readiness - "Do you have 6+ months savings?"
   - **Level 3**: Goal clarity - "Do you have clear career goals?"

3. **Branching Logic**:
   - All Y → "Go for it!" with actionable advice
   - Unhappy but no savings → Focus on financial preparation
   - Not unhappy → Stay and improve current situation
   - Each level provides contextually appropriate guidance

4. **Professional Application**: Simulates real career counseling methodology
5. **Complete Documentation**: Includes detailed problem description in block comment as required

**Design Choice**: Selected career counseling as it provides meaningful binary decisions with practical, actionable outcomes at each level.

---

## **Overall Programming Concepts Demonstrated**

### **Advanced Selection Structures**:
1. **Composite Error Handling** (Problem 1): Accumulating multiple validation errors
2. **Nested Validation** (Problems 2, 4, 5): Layered decision making with dependencies
3. **Multiple Selection** (Problems 2, 3): Efficient if-else if chains
4. **Early Termination** (Problem 4): Stopping execution when criteria not met

### **String Class Mastery**:
- **Search methods**: `indexOf()`, `contains()`
- **Extraction methods**: `substring()`
- **Validation methods**: `endsWith()`, `equals()`
- **Manipulation methods**: `toUpperCase()`
- **Comparison**: Using `.equals()` instead of `==` for Strings

### **Real-World Applications**:
- **Data validation**: Email format checking (Problem 1)
- **Educational systems**: Grade calculation (Problem 2)
- **Aviation safety**: Navigation and communication (Problem 3)
- **Market research**: Participant screening (Problem 4)
- **Career counseling**: Decision support systems (Problem 5)

### **Algorithm Efficiency**:
- **Drop-through logic**: Avoiding redundant comparisons
- **Early exit strategies**: Minimizing unnecessary processing
- **Composite pattern**: Building complex validation from simple tests
