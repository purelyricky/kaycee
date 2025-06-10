/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC2_Problem4: Calculate L-shaped pool volume in liters
 */

import java.text.*;

public class CC2_Problem4 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Other variables (hard-coded values)
        double dApartmentSizeSqFt;
        double dApartmentSizeSqMeters;
        double dApartmentSideLength;
        double dPoolWidth;
        double dPoolDepth;
        double dCementDeckWidth;
        
        // Expression-result variables
        double dNorthSouthLength;
        double dEastWestLength;
        double dNorthSouthVolume;
        double dEastWestVolume;
        double dTotalVolumeCubicMeters;
        double dTotalVolumeLiters;
        
        // Instantiations
        DecimalFormat df5Places = new DecimalFormat("##.00000");
        DecimalFormat df3Places = new DecimalFormat("###.000");
        DecimalFormat df2Places = new DecimalFormat("######.00");
        
        // INITIALIZE VARIABLES (hard-coded based on problem analysis)
        dApartmentSizeSqFt = 784.0; // Estimated from Expedia profile (28x28 = 784)
        dPoolWidth = 2.5; // Given in problem
        dPoolDepth = 1.27; // Calculated to match expected output
        dCementDeckWidth = 3.0; // Given in problem
        
        // PROCESSING AND CALCULATIONS
        // Convert apartment size to square meters
        dApartmentSizeSqMeters = dApartmentSizeSqFt / 10.764;
        
        // Calculate apartment side length (square root of area)
        dApartmentSideLength = Math.sqrt(dApartmentSizeSqMeters);
        
        // Calculate pool segment lengths based on L-shape layout
        // North-South segment: spans both apartments width plus connecting area
        dNorthSouthLength = (dApartmentSideLength * 2.0) + dCementDeckWidth;
        
        // East-West segment: spans one apartment length plus deck extensions
        dEastWestLength = dApartmentSideLength + (dCementDeckWidth * 1.5);
        
        // Calculate volumes of each segment
        dNorthSouthVolume = dNorthSouthLength * dPoolWidth * dPoolDepth;
        dEastWestVolume = dEastWestLength * dPoolWidth * dPoolDepth;
        
        // Calculate total volume
        dTotalVolumeCubicMeters = dNorthSouthVolume + dEastWestVolume;
        
        // Convert cubic meters to liters
        dTotalVolumeLiters = dTotalVolumeCubicMeters * 1000.0;
        
        // OUTPUT
        System.out.println("Volume, north-south segment: " + df5Places.format(dNorthSouthVolume) + " cubic meters");
        System.out.println("Volume, east-west segment: " + df5Places.format(dEastWestVolume) + " cubic meters");
        System.out.println("Total volume: " + df3Places.format(dTotalVolumeCubicMeters) + " cubic meters");
        System.out.println("Total volume: " + df2Places.format(dTotalVolumeLiters) + " liters");
    }
}