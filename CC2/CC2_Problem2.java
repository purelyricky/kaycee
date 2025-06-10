/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC2_Problem2: Pizza cost calculator
 */

import java.text.*;
import java.util.Scanner;

public class CC2_Problem2 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        double dCost;
        double dDiameter;
        int iSlices;
        
        // Expression-result variables
        double dRadius;
        double dArea;
        double dCostPerSquareInch;
        double dCostPerSlice;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // Instantiations
        DecimalFormat dfUSD = new DecimalFormat("$###,###.00");
        DecimalFormat dfArea = new DecimalFormat("###.00");
        
        // INPUT
        System.out.print("Cost for whole pizza: ");
        dCost = cin.nextDouble();
        
        System.out.print("Diameter in inches: ");
        dDiameter = cin.nextDouble();
        
        System.out.print("Number of slices: ");
        iSlices = cin.nextInt();
        
        // PROCESSING AND CALCULATIONS
        dRadius = dDiameter / 2.0;
        dArea = Math.PI * dRadius * dRadius;
        dCostPerSquareInch = dCost / dArea;
        dCostPerSlice = dCost / (double)iSlices;
        
        // OUTPUT
        System.out.println("Cost for whole pizza: " + dfUSD.format(dCost));
        System.out.println("Diameter: " + dfArea.format(dDiameter));
        System.out.println("Number of square inches: " + dfArea.format(dArea));
        System.out.println("Cost per square inch: " + dfUSD.format(dCostPerSquareInch));
        System.out.println("Slices: " + iSlices);
        System.out.println("Cost per slice: " + dfUSD.format(dCostPerSlice));
        
        cin.close();
    }
}