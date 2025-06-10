/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC1_Problem1: Basic arithmetic with variables using double data type
 */

public class CC1_Problem1 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Other variables
        // int iVal1;  // commented out - original int version
        // int iVal2;  // commented out - original int version
        // int iSum;   // commented out - original int version
        
        // Input-capture variables (using double for fractional values)
        double dVal1;
        double dVal2;
        
        // Expression/Result Variables
        double dSum;
        
        // INITIALIZE VARIABLES
        // iVal1 = 3;      // commented out - original int version
        // iVal2 = 4;      // commented out - original int version
        
        dVal1 = 3.26;   // Using fractional values to demonstrate double precision
        dVal2 = 15.54;
        
        // PROCESSING AND CALCULATIONS
        // iSum = iVal1 + iVal2;  // commented out - original int version
        
        dSum = dVal1 + dVal2;
        
        // OUTPUT
        System.out.println("The sum of " + dVal1 + " and " + dVal2 + " is " + dSum);
    }
}