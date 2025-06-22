/*
 * Developer: Madubuko Divine
 * Date: 06/22/2025
 * Description:Triangle of asterisks using nested loops and void methods
 */

import java.util.Scanner;

public class CC6_Problem1 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        int iNum;
        
        // INPUT AND VALIDATION
        System.out.print("Enter the size of the triangle (1-50): ");
        iNum = cin.nextInt();
        
        // Validate input
        if (iNum >= 1 && iNum <= 50) {
            // Call method to draw triangle
            fvDrawTriangle(iNum);
        } else {
            System.out.println("Error: Value must be between 1 and 50");
        }
        
        cin.close();
    }
    
    // Method to draw triangle of asterisks
    public static void fvDrawTriangle(int piMax) {
        // Outer loop for rows (decreasing asterisks)
        for (int iRow = piMax; iRow >= 1; iRow--) {
            // Inner loop for asterisks in each row
            for (int iCol = 1; iCol <= iRow; iCol++) {
                System.out.print("*");
            }
            System.out.println(); // Move to next line after each row
        }
    }
}