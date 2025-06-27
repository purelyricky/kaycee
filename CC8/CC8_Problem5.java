/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Cascading methods for statistical calculations
 * First method calculates mean, second method uses mean to calculate standard deviation
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC8_Problem5 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        double dMean;
        double dStandardDeviation;
        DecimalFormat df3 = new DecimalFormat("0.000");
        
        // Get the number of values
        System.out.print("How many numbers will you enter? ");
        int iCount = cin.nextInt();
        
        // Create array to store values
        double[] adValues = new double[iCount];
        
        // Get values from user
        for (int i = 0; i < iCount; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            adValues[i] = cin.nextDouble();
        }
        
        // CASCADING METHOD CALLS
        // First child method calculates and returns mean
        dMean = fdCalculateMean(adValues);
        
        // Second child method uses mean to calculate standard deviation
        dStandardDeviation = fdCalculateStandardDeviation(adValues, dMean);
        
        // OUTPUT
        System.out.println();
        System.out.println("=== STATISTICAL ANALYSIS ===");
        System.out.println("Number of values: " + iCount);
        System.out.println("Mean (average): " + df3.format(dMean));
        System.out.println("Standard deviation: " + df3.format(dStandardDeviation));
        
        // Provide interpretation
        if (dStandardDeviation < 1.0) {
            System.out.println("Low variability - values are close to the mean");
        } else if (dStandardDeviation < 3.0) {
            System.out.println("Moderate variability in the data");
        } else {
            System.out.println("High variability - values are spread out");
        }
        
        cin.close();
    }
    
    // First child method - calculates mean (average)
    public static double fdCalculateMean(double[] padValues) {
        double dSum = 0.0;
        
        // Sum all values
        for (int i = 0; i < padValues.length; i++) {
            dSum = dSum + padValues[i];
        }
        
        // Return mean
        return dSum / padValues.length;
    }
    
    // Second child method - uses mean from first method to calculate standard deviation
    public static double fdCalculateStandardDeviation(double[] padValues, double pdMean) {
        double dSumOfSquares = 0.0;
        double dVariance;
        
        // Calculate sum of squared differences from mean
        for (int i = 0; i < padValues.length; i++) {
            double dDifference = padValues[i] - pdMean;
            dSumOfSquares = dSumOfSquares + (dDifference * dDifference);
        }
        
        // Calculate variance (using n-1 for sample standard deviation)
        dVariance = dSumOfSquares / (padValues.length - 1);
        
        // Return standard deviation (square root of variance)
        return Math.sqrt(dVariance);
    }
}