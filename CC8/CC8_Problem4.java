/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Refactored pizza cost calculator with three value-returning methods
 * Original basis: CC2_Problem2 (Pizza cost calculation)
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC8_Problem4 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        double dDiameter;
        double dCost;
        double dSurfaceArea;
        double dCostPerSquareInch;
        double dCostPerSlice;
        int iSlices;
        DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        // Get input values
        dDiameter = fdGetPizzaDiameter();
        dCost = fdGetPizzaCost();
        iSlices = fiGetNumberOfSlices();
        
        // Calculate surface area
        dSurfaceArea = fdCalculatePizzaArea(dDiameter);
        
        // Calculate costs
        dCostPerSquareInch = dCost / dSurfaceArea;
        dCostPerSlice = dCost / (double)iSlices;
        
        // OUTPUT
        System.out.println();
        System.out.println("Cost for whole pizza: " + dfCurrency.format(dCost));
        System.out.println("Diameter: " + df2.format(dDiameter));
        System.out.println("Number of square inches: " + df2.format(dSurfaceArea));
        System.out.println("Cost per square inch: " + dfCurrency.format(dCostPerSquareInch));
        System.out.println("Slices: " + iSlices);
        System.out.println("Cost per slice: " + dfCurrency.format(dCostPerSlice));
    }
    
    // First child method - get pizza diameter
    public static double fdGetPizzaDiameter() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Diameter in inches: ");
        return cin.nextDouble();
    }
    
    // Second child method - get pizza cost
    public static double fdGetPizzaCost() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Cost for whole pizza: ");
        return cin.nextDouble();
    }
    
    // Third child method - get number of slices
    public static int fiGetNumberOfSlices() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Number of slices: ");
        return cin.nextInt();
    }
    
    // Helper method to calculate pizza area
    public static double fdCalculatePizzaArea(double pdDiameter) {
        double dRadius = pdDiameter / 2.0;
        return Math.PI * dRadius * dRadius;
    }
}