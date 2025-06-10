/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC2_Problem1: Calculate volume of a sphere
 */

import java.text.*;
import java.util.Scanner;

public class CC2_Problem1 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        double dDiameter;
        
        // Expression-result variables
        double dRadius;
        double dVolume;
        
        // Other variables
        double dPi;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // Instantiations
        DecimalFormat dfVolume = new DecimalFormat("##.00");
        
        // INITIALIZE VARIABLES
        dPi = 3.14;
        
        // INPUT
        System.out.print("Enter the diameter of the sphere in inches: ");
        dDiameter = cin.nextDouble();
        
        // PROCESSING AND CALCULATIONS
        dRadius = dDiameter / 2.0;
        dVolume = (4.0 / 3.0) * dPi * dRadius * dRadius * dRadius;
        
        // OUTPUT
        System.out.println("Volume of sphere: " + dfVolume.format(dVolume) + " cubic inches");
        
        cin.close();
    }
}