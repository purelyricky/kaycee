/*
 * Developer: Madubuko Divine
 * Date: 06/22/2025
 * Description: Refactored circle area calculator with input validation and methods
 * Original basis: CC2_Problem1 (Volume calculation) - modified for circle area
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC6_Problem4 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        double dRadius;
        double dArea;
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        // INPUT WITH VALIDATION LOOP
        do {
            System.out.print("Enter the radius of the circle (0.1 to 100.0): ");
            dRadius = cin.nextDouble();
            
            if (dRadius < 0.1 || dRadius > 100.0) {
                System.out.println("Error: Radius must be between 0.1 and 100.0");
                System.out.println("Please try again.");
            }
        } while (dRadius < 0.1 || dRadius > 100.0);
        
        // PROCESSING
        dArea = Math.PI * dRadius * dRadius;
        
        // OUTPUT
        System.out.println();
        System.out.println("Circle radius: " + df2.format(dRadius) + " units");
        System.out.println("Circle area: " + df2.format(dArea) + " square units");
        
        // Call void method to display additional information
        fvDisplayCircleInfo(dRadius);
        
        cin.close();
    }
    
    // Void method to display additional circle information
    public static void fvDisplayCircleInfo(double pdRadius) {
        double dCircumference;
        double dDiameter;
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        // Calculate additional circle properties
        dDiameter = pdRadius * 2.0;
        dCircumference = 2.0 * Math.PI * pdRadius;
        
        // Display additional information
        System.out.println();
        System.out.println("=== Additional Circle Information ===");
        System.out.println("Diameter: " + df2.format(dDiameter) + " units");
        System.out.println("Circumference: " + df2.format(dCircumference) + " units");
        
        // Provide some context about the circle size
        if (pdRadius < 1.0) {
            System.out.println("This is a small circle.");
        } else if (pdRadius < 10.0) {
            System.out.println("This is a medium-sized circle.");
        } else {
            System.out.println("This is a large circle.");
        }
    }
}