/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Refactored input validation with captive structure
 * Based on Chapter 6 captive structure concepts
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC8_Problem3 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        double dGPA;
        String sClassification;
        DecimalFormat df2 = new DecimalFormat("0.00");
        
        // Get validated GPA from user
        dGPA = fdGetValidGPA();
        
        // Determine and display classification
        sClassification = fsClassifyStudent(dGPA);
        
        // OUTPUT
        System.out.println();
        System.out.println("Your GPA: " + df2.format(dGPA));
        System.out.println("Classification: " + sClassification);
    }
    
    // Value-returning method with captive structure for input validation
    public static double fdGetValidGPA() {
        Scanner cin = new Scanner(System.in);
        double dGPA;
        
        // Captive structure - keeps asking until valid input
        do {
            System.out.print("Enter your GPA (0.0 to 4.0): ");
            dGPA = cin.nextDouble();
            
            if (dGPA < 0.0 || dGPA > 4.0) {
                System.out.println("Error: GPA must be between 0.0 and 4.0");
            }
        } while (dGPA < 0.0 || dGPA > 4.0);
        
        return dGPA;
    }
    
    // Helper method to classify student based on GPA
    public static String fsClassifyStudent(double pdGPA) {
        if (pdGPA >= 3.5) {
            return "Dean's List";
        } else if (pdGPA >= 3.0) {
            return "Good Standing";
        } else if (pdGPA >= 2.0) {
            return "Satisfactory";
        } else {
            return "Academic Probation";
        }
    }
}