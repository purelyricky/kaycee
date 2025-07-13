/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC12_Problem4: Sample standard deviation calculation for jagged 2D array
 */

import java.text.DecimalFormat;

public class CC12_Problem4 {
    
    public static void main(String[] args) {
        // Create and populate jagged array using shortcut notation
        int[][] iVals = {{3, 7, 1, 4}, 
                         {9, 4, 8, 2}, 
                         {9, 5}, 
                         {4, 0, 5, 8}};
        
        DecimalFormat df2 = new DecimalFormat("#,##0.00");
        
        // Display the array
        fvDisplayArray(iVals);
        System.out.println();
        
        // Calculate and display all statistics
        int iCount = fiCountElements(iVals);
        System.out.println("Count (n): " + iCount);
        
        double dMean = fdCalculateMean(iVals);
        System.out.println("Mean: " + df2.format(dMean));
        
        double dSumOfSquares = fdCalculateSumOfSquares(iVals, dMean);
        System.out.println("Sum of squares: " + df2.format(dSumOfSquares));
        
        double dVariance = fdCalculateVariance(iVals, dSumOfSquares);
        System.out.println("Variance: " + df2.format(dVariance));
        
        double dStdDev = fdCalculateStandardDeviation(dVariance);
        System.out.println("Standard deviation: " + df2.format(dStdDev));
    }
    
    // Method to display array values
    public static void fvDisplayArray(int[][] piVals) {
        for (int iRow = 0; iRow < piVals.length; iRow++) {
            for (int iCol = 0; iCol < piVals[iRow].length; iCol++) {
                System.out.print(piVals[iRow][iCol] + " ");
            }
            System.out.println();
        }
    }
    
    // Method to count total number of elements
    public static int fiCountElements(int[][] piVals) {
        int iCount = 0;
        for (int iRow = 0; iRow < piVals.length; iRow++) {
            for (int iCol = 0; iCol < piVals[iRow].length; iCol++) {
                iCount++;
            }
        }
        return iCount;
    }
    
    // Method to calculate mean of all values
    public static double fdCalculateMean(int[][] piVals) {
        int iSum = 0;
        int iCount = 0;
        
        for (int iRow = 0; iRow < piVals.length; iRow++) {
            for (int iCol = 0; iCol < piVals[iRow].length; iCol++) {
                iSum = iSum + piVals[iRow][iCol];
                iCount++;
            }
        }
        
        return (double)iSum / (double)iCount;
    }
    
    // Method to calculate sum of squares
    public static double fdCalculateSumOfSquares(int[][] piVals, double pdMean) {
        double dSumOfSquares = 0.0;
        
        for (int iRow = 0; iRow < piVals.length; iRow++) {
            for (int iCol = 0; iCol < piVals[iRow].length; iCol++) {
                double dDifference = (double)piVals[iRow][iCol] - pdMean;
                dSumOfSquares = dSumOfSquares + (dDifference * dDifference);
            }
        }
        
        return dSumOfSquares;
    }
    
    // Method to calculate variance (sample variance using n-1)
    public static double fdCalculateVariance(int[][] piVals, double pdSumOfSquares) {
        int iCount = fiCountElements(piVals);
        return pdSumOfSquares / ((double)iCount - 1.0);
    }
    
    // Method to calculate standard deviation
    public static double fdCalculateStandardDeviation(double pdVariance) {
        return Math.sqrt(pdVariance);
    }
}