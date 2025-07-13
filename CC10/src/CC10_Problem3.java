/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC10_Problem3: Array left and right shifting with captive menu
 */

import java.util.Scanner;

public class CC10_Problem3 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        int[] iNums = {47, 93, 108, 173, 4, 38, 62, 87, 19, 11};
        String sChoice;
        
        // Display initial array
        fvDisplayArray(iNums, "Native Order");
        
        // PROCESSING - Captive menu system
        do {
            System.out.println();
            System.out.print("Enter L for left shift, R for right, Q to quit: ");
            sChoice = cin.nextLine().toUpperCase();
            
            if (sChoice.equals("L")) {
                fvShiftArray(iNums, "L");
                fvDisplayArray(iNums, "Left Shifted");
            } else if (sChoice.equals("R")) {
                fvShiftArray(iNums, "R");
                fvDisplayArray(iNums, "Right Shifted");
            } else if (sChoice.equals("Q")) {
                System.out.println("Program terminated.");
            } else {
                System.out.println("Error: type L, R, or Q");
            }
        } while (!sChoice.equals("Q"));
        
        cin.close();
    }
    
    // Method to display array with caption
    public static void fvDisplayArray(int[] piNums, String psCaption) {
        System.out.print(psCaption + ": ");
        for (int i = 0; i < piNums.length; i++) {
            System.out.print(piNums[i] + " ");
        }
        System.out.println();
    }
    
    // Method to shift array left or right
    public static void fvShiftArray(int[] piNums, String psDirection) {
        if (psDirection.equals("L")) {
            // Left shift - first element moves to end
            int iTemp = piNums[0];
            for (int i = 0; i < piNums.length - 1; i++) {
                piNums[i] = piNums[i + 1];
            }
            piNums[piNums.length - 1] = iTemp;
        } else if (psDirection.equals("R")) {
            // Right shift - last element moves to beginning
            int iTemp = piNums[piNums.length - 1];
            for (int i = piNums.length - 1; i > 0; i--) {
                piNums[i] = piNums[i - 1];
            }
            piNums[0] = iTemp;
        }
    }
}