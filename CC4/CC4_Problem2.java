/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC4_Problem2: Grade calculator with nested if structure
 */

import java.util.Scanner;

public class CC4_Problem2 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        double dScore;
        String sLetterGrade;
        
        // INPUT
        System.out.print("Numeric score: ");
        dScore = cin.nextDouble();
        
        // PROCESSING - Outer if for range validation
        if (dScore < 0.0 || dScore > 100.0)
        {
            System.out.println("Invalid data; range is 0 to 100");
        }
        else
        {
            // Inner multiple-selection if for grade determination
            if (dScore >= 93.0)
            {
                sLetterGrade = "A";
            }
            else if (dScore >= 90.0)
            {
                sLetterGrade = "A-";
            }
            else if (dScore >= 87.0)
            {
                sLetterGrade = "B+";
            }
            else if (dScore >= 83.0)
            {
                sLetterGrade = "B";
            }
            else if (dScore >= 80.0)
            {
                sLetterGrade = "B-";
            }
            else if (dScore >= 77.0)
            {
                sLetterGrade = "C+";
            }
            else if (dScore >= 73.0)
            {
                sLetterGrade = "C";
            }
            else if (dScore >= 70.0)
            {
                sLetterGrade = "C-";
            }
            else if (dScore >= 67.0)
            {
                sLetterGrade = "D+";
            }
            else if (dScore >= 63.0)
            {
                sLetterGrade = "D";
            }
            else if (dScore >= 60.0)
            {
                sLetterGrade = "D-";
            }
            else
            {
                sLetterGrade = "F";
            }
            
            // OUTPUT
            System.out.println("Letter grade: " + sLetterGrade);
        }
        
        cin.close();
    }
}