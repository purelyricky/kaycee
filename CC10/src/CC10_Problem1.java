/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC10_Problem1: Grade distribution analysis using random exam scores
 */

import java.util.Random;

public class CC10_Problem1 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        final int ARRAY_SIZE = 50;
        int[] iScores = new int[ARRAY_SIZE];
        Random rand = new Random();
        
        // Counters for each grade
        int iCountA = 0;
        int iCountB = 0; 
        int iCountC = 0;
        int iCountD = 0;
        int iCountF = 0;
        
        // PROCESSING - Populate array with random scores
        for (int i = 0; i < iScores.length; i++) {
            iScores[i] = rand.nextInt(101); // 0 to 100 inclusive
        }
        
        // Categorize scores into grade ranges
        for (int i = 0; i < iScores.length; i++) {
            if (iScores[i] >= 90) {
                iCountA = iCountA + 1;
            } else if (iScores[i] >= 80) {
                iCountB = iCountB + 1;
            } else if (iScores[i] >= 70) {
                iCountC = iCountC + 1;
            } else if (iScores[i] >= 60) {
                iCountD = iCountD + 1;
            } else {
                iCountF = iCountF + 1;
            }
        }
        
        // OUTPUT
        System.out.println("Grade Distribution");
        System.out.println("A: " + iCountA);
        System.out.println("B: " + iCountB);
        System.out.println("C: " + iCountC);
        System.out.println("D: " + iCountD);
        System.out.println("F: " + iCountF);
    }
}