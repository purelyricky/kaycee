/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Enhanced epsilon comparison with multiple methods
 * Original basis: CC3_Problem1 (Epsilon comparison for floating point)
 */

import java.text.DecimalFormat;

public class CC7_Problem5 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        double dCalculatedSum;
        double dActualSum;
        double dDifference;
        
        // Call methods to perform calculations
        dCalculatedSum = fdCalculateSum();
        dActualSum = fdGetActualSum();
        dDifference = fdCalculateDifference(dCalculatedSum, dActualSum);
        
        // Display initial results
        fvDisplayValues(dCalculatedSum, dActualSum, dDifference);
        
        // Perform comparisons
        fvPerformComparisons(dCalculatedSum, dActualSum);
        
        // Display explanation
        fvDisplayExplanation();
    }
    
    // Method to calculate the floating-point sum
    public static double fdCalculateSum() {
        return 0.1 + 0.2 + 0.3;
    }
    
    // Method to get the expected actual sum
    public static double fdGetActualSum() {
        return 0.6;
    }
    
    // Method to calculate difference between two values
    public static double fdCalculateDifference(double pdValue1, double pdValue2) {
        return pdValue1 - pdValue2;
    }
    
    // Void method to display the calculated values
    public static void fvDisplayValues(double pdCalculated, double pdActual, double pdDifference) {
        System.out.println("Calculated sum: " + pdCalculated);
        System.out.println("Actual sum: " + pdActual);
        System.out.println("Calculated sum -- actual sum: " + pdDifference);
        System.out.println();
    }
    
    // Void method to perform and display comparisons
    public static void fvPerformComparisons(double pdCalculated, double pdActual) {
        double dEpsilon = 0.001;
        
        // Test using == operator
        if (pdActual == pdCalculated) {
            System.out.println("The comparison evaluates to EQUAL using ==");
        } else {
            System.out.println("The comparison evaluates to NOT EQUAL using ==");
        }
        
        // Test using epsilon method
        if (Math.abs(pdActual - pdCalculated) < dEpsilon) {
            System.out.println("The comparison is CLOSE ENOUGH TO BE CONSIDERED NEARLY EQUAL at .001 epsilon");
        } else {
            System.out.println("The comparison is NOT CLOSE ENOUGH TO BE CONSIDERED NEARLY EQUAL at .001 epsilon");
        }
        System.out.println();
    }
    
    // Void method to display explanation of floating-point precision
    public static void fvDisplayExplanation() {
        System.out.println("=== EXPLANATION ===");
        System.out.println("Floating-point arithmetic can introduce tiny rounding errors");
        System.out.println("due to the way computers represent decimal numbers in binary.");
        System.out.println("The epsilon method provides a tolerance for 'close enough' comparisons.");
        System.out.println("This is why direct equality (==) often fails with floating-point numbers.");
    }
}