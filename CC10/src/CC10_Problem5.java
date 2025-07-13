/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC10_Problem5: Selection sort implementation with demonstration
 */

import java.util.Random;
import java.util.Scanner;

public class CC10_Problem5 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        final int ARRAY_SIZE = 12;
        int[] iNums = new int[ARRAY_SIZE];
        
        System.out.println("=== SELECTION SORT DEMONSTRATION ===");
        System.out.println();
        
        // Populate array with random numbers
        fvPopulateArray(iNums, 10, 99);
        
        // Display original array
        fvDisplayArray(iNums, "Original Array");
        
        // Perform selection sort
        int iComparisons = fiSelectionSort(iNums);
        
        // Display sorted array
        fvDisplayArray(iNums, "Sorted Array (Ascending)");
        System.out.println("Total comparisons made: " + iComparisons);
        
        // Demonstrate understanding of different sorting algorithms
        fvExplainSortingAlgorithms();
        
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
    
    // Method to perform selection sort and count comparisons
    public static int fiSelectionSort(int[] piNums) {
        int iComparisons = 0;
        
        // Selection sort algorithm
        for (int i = 0; i < piNums.length - 1; i++) {
            // Find minimum element in remaining unsorted array
            int iMinIndex = i;
            
            for (int j = i + 1; j < piNums.length; j++) {
                iComparisons = iComparisons + 1;
                if (piNums[j] < piNums[iMinIndex]) {
                    iMinIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            if (iMinIndex != i) {
                int iTemp = piNums[i];
                piNums[i] = piNums[iMinIndex];
                piNums[iMinIndex] = iTemp;
                
                // Show step-by-step progress
                System.out.print("Step " + (i + 1) + " - Swapped " + piNums[iMinIndex] + 
                               " and " + piNums[i] + ": ");
                for (int k = 0; k < piNums.length; k++) {
                    System.out.print(piNums[k] + " ");
                }
                System.out.println();
            }
        }
        
        return iComparisons;
    }
    
    // Method to explain differences between sorting algorithms
    public static void fvExplainSortingAlgorithms() {
        System.out.println();
        System.out.println("=== SORTING ALGORITHM COMPARISON ===");
        System.out.println();
        
        System.out.println("BUBBLE SORT:");
        System.out.println("- Compares adjacent elements and swaps if they're in wrong order");
        System.out.println("- 'Bubbles' the largest element to the end in each pass");
        System.out.println("- Time Complexity: O(n²) average and worst case");
        System.out.println("- Simple but inefficient for large datasets");
        System.out.println();
        
        System.out.println("SELECTION SORT:");
        System.out.println("- Finds the minimum element and places it at the beginning");
        System.out.println("- Divides array into sorted and unsorted portions");
        System.out.println("- Time Complexity: O(n²) but fewer swaps than bubble sort");
        System.out.println("- More efficient than bubble sort for small datasets");
        System.out.println();
        
        System.out.println("INSERTION SORT:");
        System.out.println("- Builds sorted array one element at a time");
        System.out.println("- Inserts each element into its correct position");
        System.out.println("- Time Complexity: O(n²) worst case, O(n) best case");
        System.out.println("- Very efficient for small or nearly sorted datasets");
        System.out.println();
        
        System.out.println("PERFORMANCE COMPARISON:");
        System.out.println("Best to Worst for small arrays: Insertion → Selection → Bubble");
        System.out.println("All three are O(n²) algorithms, not suitable for large datasets");
    }
}