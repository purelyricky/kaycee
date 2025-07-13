/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC10_Problem4: Bubble sort with ascending/descending options and interchange counting
 */

import java.util.Scanner;
import java.util.Random;

public class CC10_Problem4 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        final int ARRAY_SIZE = 10;
        int[] iNums = new int[ARRAY_SIZE];
        String sChoice;
        
        // Populate array with random numbers
        fvPopulateArray(iNums, 1, 200);
        
        // Display initial array
        fvDisplayArray(iNums, "Native Order");
        
        // PROCESSING - Captive menu system
        do {
            System.out.println();
            System.out.print("Enter A for ascending sort, D for descending, Q to quit: ");
            sChoice = cin.nextLine().toUpperCase();
            
            if (sChoice.equals("A")) {
                int iInterchanges = fiBubbleSortAscending(iNums);
                fvDisplayArray(iNums, "Ascending Order");
                System.out.println("Interchanges required to sort: " + iInterchanges);
            } else if (sChoice.equals("D")) {
                int iInterchanges = fiBubbleSortDescending(iNums);
                fvDisplayArray(iNums, "Descending Order");
                System.out.println("Interchanges required to sort: " + iInterchanges);
            } else if (sChoice.equals("Q")) {
                System.out.println("Program terminated.");
            } else {
                System.out.println("Error: type A, D, or Q");
            }
        } while (!sChoice.equals("Q"));
        
        cin.close();
    }
    
    // Method to populate array with random numbers
    public static void fvPopulateArray(int[] piNums, int piMin, int piMax) {
        Random rand = new Random();
        for (int i = 0; i < piNums.length; i++) {
            piNums[i] = rand.nextInt(piMax - piMin + 1) + piMin;
        }
    }
    
    // Method to display array with caption
    public static void fvDisplayArray(int[] piNums, String psCaption) {
        System.out.print(psCaption + ": ");
        for (int i = 0; i < piNums.length; i++) {
            System.out.print(piNums[i] + " ");
        }
        System.out.println();
    }
    
    // Method to bubble sort in ascending order
    public static int fiBubbleSortAscending(int[] piNums) {
        int iInterchanges = 0;
        boolean bSwapped;
        
        for (int i = 0; i < piNums.length - 1; i++) {
            bSwapped = false;
            for (int j = 0; j < piNums.length - 1 - i; j++) {
                if (piNums[j] > piNums[j + 1]) {
                    // Swap elements
                    int iTemp = piNums[j];
                    piNums[j] = piNums[j + 1];
                    piNums[j + 1] = iTemp;
                    iInterchanges = iInterchanges + 1;
                    bSwapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!bSwapped) {
                break;
            }
        }
        
        return iInterchanges;
    }
    
    // Method to bubble sort in descending order
    public static int fiBubbleSortDescending(int[] piNums) {
        int iInterchanges = 0;
        boolean bSwapped;
        
        for (int i = 0; i < piNums.length - 1; i++) {
            bSwapped = false;
            for (int j = 0; j < piNums.length - 1 - i; j++) {
                if (piNums[j] < piNums[j + 1]) {
                    // Swap elements
                    int iTemp = piNums[j];
                    piNums[j] = piNums[j + 1];
                    piNums[j + 1] = iTemp;
                    iInterchanges = iInterchanges + 1;
                    bSwapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!bSwapped) {
                break;
            }
        }
        
        return iInterchanges;
    }
}