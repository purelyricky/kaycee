/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC3_Problem2: Photocopy pricing calculator
 */

import java.text.*;
import java.util.Scanner;

public class CC3_Problem2 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        int iCopies;
        
        // Expression-result variables
        int iExcessCopies;
        double dCost;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // DecimalFormat instantiation
        DecimalFormat dfCurrency = new DecimalFormat("$#.00");
        
        // INPUT
        System.out.print("Number of copies: ");
        iCopies = cin.nextInt();
        
        // PROCESSING AND CALCULATIONS
        if (iCopies <= 50)
        {
            // True branch: 50 copies or fewer
            dCost = iCopies * 0.09;
            System.out.println("Total cost: " + dfCurrency.format(dCost));
        }
        else
        {
            // False branch: More than 50 copies
            iExcessCopies = iCopies - 50;
            dCost = (50 * 0.09) + (iExcessCopies * 0.05);
            System.out.println("Total cost: " + dfCurrency.format(dCost));
        }
        
        cin.close();
    }
}