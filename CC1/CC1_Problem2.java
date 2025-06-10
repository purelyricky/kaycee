/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC1_Problem2: arithmetic operations with end-user input
 */

import java.util.Scanner;

public class CC1_Problem2 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        double dValue1;
        double dValue2;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // Expression-result variables
        double dSum;
        double dProduct;
        double dDifference;
        double dQuotient;
        double dSquared;
        
        // INPUT
        // Prompt for the first value:
        System.out.print("Enter the first value: ");
        dValue1 = cin.nextDouble();
        
        // Prompt for the second value:
        System.out.print("Enter the second value: ");
        dValue2 = cin.nextDouble();
        
        // PROCESSING AND CALCULATIONS
        dSum = dValue1 + dValue2;
        dProduct = dValue1 * dValue2;
        dDifference = dValue1 - dValue2;
        dQuotient = dValue1 / dValue2;
        dSquared = dValue1 * dValue1;
        
        // OUTPUT
        // Output sum:
        System.out.println("The sum of " + dValue1 + " plus " + dValue2 + " is " + dSum);
        
        // Output product:
        System.out.println("The product of " + dValue1 + " and " + dValue2 + " is " + dProduct);
        
        // Output difference:
        System.out.println("The difference between " + dValue1 + " and " + dValue2 + " is " + dDifference);
        
        // Output quotient:
        System.out.println("The quotient of " + dValue1 + " divided by " + dValue2 + " is " + dQuotient);
        
        // Output squared:
        System.out.println("The value of " + dValue1 + " squared is " + dSquared);
        
        cin.close();
    }
}