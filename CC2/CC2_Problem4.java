/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC2_Problem3: Pizza cost calculator in Gambian Dalasi
 */

import java.text.*;
import java.util.Scanner;

public class CC2_Problem3 
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
        double dCostDalasi;
        double dCostPerSquareInchDalasi;
        double dCostPerSliceDalasi;
        
        // Other variables
        double dExchangeRate;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // Instantiations
        DecimalFormat dfDalasi = new DecimalFormat("D###,###.00");
        DecimalFormat dfArea = new DecimalFormat("###.00");
        
        // INITIALIZE VARIABLES
        dExchangeRate = 72.0; // Current USD to GMD exchange rate
        
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
        
        // Convert to Dalasi
        dCostDalasi = dCost * dExchangeRate;
        dCostPerSquareInchDalasi = dCostPerSquareInch * dExchangeRate;
        dCostPerSliceDalasi = dCostPerSlice * dExchangeRate;
        
        // OUTPUT
        System.out.println("Cost for whole pizza: " + dfDalasi.format(dCostDalasi));
        System.out.println("Diameter: " + dfArea.format(dDiameter));
        System.out.println("Number of square inches: " + dfArea.format(dArea));
        System.out.println("Cost per square inch: " + dfDalasi.format(dCostPerSquareInchDalasi));
        System.out.println("Slices: " + iSlices);
        System.out.println("Cost per slice: " + dfDalasi.format(dCostPerSliceDalasi));
        
        cin.close();
    }
}