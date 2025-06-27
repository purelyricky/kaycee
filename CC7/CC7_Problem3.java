/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Refactored sphere volume calculator with void method
 * Original basis: CC2_Problem1 (Volume calculation for sphere)
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC7_Problem3 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        double dDiameter;
        double dVolume;
        
        // INPUT
        System.out.print("Enter the diameter of the sphere in inches: ");
        dDiameter = cin.nextDouble();
        
        // PROCESSING
        double dRadius = dDiameter / 2.0;
        double dPi = 3.14;
        dVolume = (4.0 / 3.0) * dPi * dRadius * dRadius * dRadius;
        
        // Call void method to display results
        fvDisplayResults(dDiameter, dVolume);
        
        cin.close();
    }
    
    // Void method to display formatted results
    public static void fvDisplayResults(double pdDiameter, double pdVolume) {
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        System.out.println();
        System.out.println("=== SPHERE CALCULATION RESULTS ===");
        System.out.println("Diameter: " + df2.format(pdDiameter) + " inches");
        System.out.println("Volume of sphere: " + df2.format(pdVolume) + " cubic inches");
        
        // Additional information
        if (pdVolume < 10.0) {
            System.out.println("This is a small sphere.");
        } else if (pdVolume < 100.0) {
            System.out.println("This is a medium sphere.");
        } else {
            System.out.println("This is a large sphere.");
        }
    }
}