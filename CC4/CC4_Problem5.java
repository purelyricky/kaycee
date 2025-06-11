/*
 * PROBLEM DESCRIPTION:
 * Write a career counseling program that helps determine if someone should consider
 * making a career change. The program uses nested if statements to evaluate three
 * criteria in order:
 * 
 * 1. First, ask if the person is unhappy in their current job (Y/N)
 * 2. If they are unhappy, ask if they have sufficient financial savings to support
 *    a career transition period of 6+ months (Y/N)
 * 3. If they have savings, ask if they have a clear career goal in mind (Y/N)
 * 
 * The program should only continue to the next question if the previous answer 
 * was "Y". If any answer is "N", provide appropriate advice and stop asking
 * further questions. Each question should validate input and only accept Y or N.
 * 
 * Sample outputs:
 * - If all Y: "Go for it! You have all the key ingredients for a successful career change."
 * - If unhappy but no savings: "Focus on building your savings first before making a change."
 * - If not unhappy: "Consider staying in your current role and finding ways to improve satisfaction."
 * - For invalid input: "Error: Please enter Y or N only."
 */

/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC4_Problem5: Career change counseling program using nested if structure
 */

import java.util.Scanner;

public class CC4_Problem5 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        String sAns;
        
        // First question: Job satisfaction
        System.out.print("Are you unhappy in your current job? Y or N: ");
        sAns = cin.next();
        sAns = sAns.toUpperCase();
        
        if (sAns.equals("Y"))
        {
            // Second question: Financial readiness
            System.out.print("Do you have 6+ months of savings for career transition? Y or N: ");
            sAns = cin.next();
            sAns = sAns.toUpperCase();
            
            if (sAns.equals("Y"))
            {
                // Third question: Career clarity
                System.out.print("Do you have a clear career goal in mind? Y or N: ");
                sAns = cin.next();
                sAns = sAns.toUpperCase();
                
                if (sAns.equals("Y"))
                {
                    System.out.println("Go for it! You have all the key ingredients for a successful career change.");
                    System.out.println("Consider creating a transition timeline and networking in your target field.");
                }
                else if (sAns.equals("N"))
                {
                    System.out.println("Take time to explore and clarify your career goals before making a change.");
                    System.out.println("Consider career assessments, informational interviews, or job shadowing.");
                }
                else
                {
                    System.out.println("Error: Please enter Y or N only.");
                }
            }
            else if (sAns.equals("N"))
            {
                System.out.println("Focus on building your savings first before making a career change.");
                System.out.println("Aim for 6-12 months of expenses saved to provide a safety net.");
            }
            else
            {
                System.out.println("Error: Please enter Y or N only.");
            }
        }
        else if (sAns.equals("N"))
        {
            System.out.println("Consider staying in your current role and finding ways to improve job satisfaction.");
            System.out.println("Try talking with your manager about new challenges or professional development opportunities.");
        }
        else
        {
            System.out.println("Error: Please enter Y or N only.");
        }
        
        cin.close();
    }
}