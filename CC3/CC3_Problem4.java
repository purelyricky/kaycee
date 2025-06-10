/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC3_Problem4: Compass heading calculator for left turns
 */

import java.util.Scanner;

public class CC3_Problem4 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        int iInitHeading;
        int iTurn;
        
        // Expression-result variables
        int iNewHeading;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // INPUT
        System.out.print("Initial heading: ");
        iInitHeading = cin.nextInt();
        
        System.out.print("Number of degrees you are turning to the left: ");
        iTurn = cin.nextInt();
        
        // PROCESSING AND CALCULATIONS
        iNewHeading = iInitHeading - iTurn;
        
        // Correction for negative or zero headings (single-selection if)
        if (iNewHeading <= 0)
        {
            iNewHeading = iNewHeading + 360;
        }
        
        // OUTPUT
        System.out.println("Initial heading: " + iInitHeading + " degrees");
        System.out.println("New heading: " + iNewHeading + " degrees");
        
        cin.close();
    }
}