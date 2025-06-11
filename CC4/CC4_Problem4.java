/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC4_Problem4: McCormick focus group eligibility checker using nested if structure
 */

import java.util.Scanner;

public class CC4_Problem4 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        String sAns;
        
        // First question: Available on date
        System.out.print("Available April 1? Y or N: ");
        sAns = cin.next();
        sAns = sAns.toUpperCase();
        
        if (sAns.equals("Y"))
        {
            // Second question: 18 or older
            System.out.print("18 or older? Y or N: ");
            sAns = cin.next();
            sAns = sAns.toUpperCase();
            
            if (sAns.equals("Y"))
            {
                // Third question: Married
                System.out.print("Married? Y or N: ");
                sAns = cin.next();
                sAns = sAns.toUpperCase();
                
                if (sAns.equals("Y"))
                {
                    System.out.println("You're eligible! Congratulations. Instructions will follow.");
                }
                else if (sAns.equals("N"))
                {
                    System.out.println("Sorry, you're not eligible. Try again in the future.");
                }
                else
                {
                    System.out.println("Error: Valid values are Y or N.");
                }
            }
            else if (sAns.equals("N"))
            {
                System.out.println("Sorry, you're not eligible. Try again in the future.");
            }
            else
            {
                System.out.println("Error: Valid values are Y or N.");
            }
        }
        else if (sAns.equals("N"))
        {
            System.out.println("Sorry, you're not eligible. Try again in the future.");
        }
        else
        {
            System.out.println("Error: Valid values are Y or N.");
        }
        
        cin.close();
    }
}