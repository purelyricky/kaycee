/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Simple main method driver with one value-returning method
 */

import java.util.Scanner;

public class CC8_Problem1 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        double dRadius;
        double dCircleArea;
        
        // INPUT
        System.out.print("Enter the radius of a circle: ");
        dRadius = cin.nextDouble();
        
        // PROCESSING - Call value-returning method
        dCircleArea = fdCalculateCircleArea(dRadius);
        
        // OUTPUT
        System.out.println("Circle with radius " + dRadius + " has area: " + dCircleArea);
        
        cin.close();
    }
    
    // Value-returning method to calculate circle area
    public static double fdCalculateCircleArea(double pdRadius) {
        return Math.PI * pdRadius * pdRadius;
    }
}