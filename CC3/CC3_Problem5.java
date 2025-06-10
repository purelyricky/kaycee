/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC3_Problem5: Student grade evaluation system
 */

import java.text.*;
import java.util.Scanner;

public class CC3_Problem5 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        double dTestScore;
        
        // Expression-result variables
        double dPointsNeeded;
        double dPointsAbove;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // DecimalFormat instantiation
        DecimalFormat dfScore = new DecimalFormat("##.0");
        
        // INPUT
        System.out.print("Enter your test score (0-100): ");
        dTestScore = cin.nextDouble();
        
        // PROCESSING AND CALCULATIONS - Double-selection if
        if (dTestScore >= 60.0)
        {
            // True branch: Passing grade
            dPointsAbove = dTestScore - 60.0;
            System.out.println("Congratulations! You PASSED the test!");
            System.out.println("Your score: " + dfScore.format(dTestScore) + "%");
            System.out.println("You scored " + dfScore.format(dPointsAbove) + " points above the passing threshold.");
            System.out.println("Great job on your academic achievement!");
        }
        else
        {
            // False branch: Failing grade
            dPointsNeeded = 60.0 - dTestScore;
            System.out.println("Unfortunately, you did not pass the test.");
            System.out.println("Your score: " + dfScore.format(dTestScore) + "%");
            System.out.println("You needed " + dfScore.format(dPointsNeeded) + " more points to pass.");
            System.out.println("Please study harder and retake the test when ready.");
        }
        
        cin.close();
    }
}