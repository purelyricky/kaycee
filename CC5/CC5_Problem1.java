/*
 * Developer: Madubuko Divine
 * Date: 06/14/2025
 * Description: CC5_Problem1: Two conversion charts using while and for loops
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC5_Problem1 {
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        int iStartValue;
        int iEndValue;
        int iCounter;
        double dResult;
        
        // INPUT AND VALIDATION
        System.out.print("Enter starting value: ");
        iStartValue = cin.nextInt();
        
        System.out.print("Enter ending value: ");
        iEndValue = cin.nextInt();
        
        // Validate input
        if (iStartValue >= iEndValue) {
            System.out.println("Error: Starting value must be less than ending value.");
            cin.close();
            return;
        }
        
        System.out.println("\n=== CHART 7: SODIUM CHLORIDE SOLUTION (3%) - WHILE LOOP ===");
        
        // WHILE LOOP - Chart 7 (Sodium Chloride)
        // D - Declare counter (already done above)
        // I - Initialize
        iCounter = iStartValue;
        // T - Test, M - Manage (in loop)
        while (iCounter <= iEndValue) {
            // For 3% solution: grams = milliliters * 0.03
            dResult = iCounter * 0.03;
            System.out.println(iCounter + " milliliters: " + df2.format(dResult) + " grams");
            iCounter = iCounter + 100; // M - Manage (increment by 100ml)
        }
        
        System.out.println("\n=== CHART 2: OUNCES TO MILLILITERS - FOR LOOP ===");
        
        // FOR LOOP - Chart 2 (Ounces to Milliliters)
        // Using smaller range for demonstration (1 to 20 in 0.5 increments)
        for (double dOunces = 1.0; dOunces <= 20.0; dOunces = dOunces + 0.5) {
            dResult = dOunces * 29.5735; // 1 ounce = 29.5735 milliliters
            System.out.println(df2.format(dOunces) + " ounce = " + df2.format(dResult) + " milliliters");
        }
        
        cin.close();
    }
}