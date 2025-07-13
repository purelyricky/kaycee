/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC12_Problem2: Two-dimensional array operations with methods
 */

public class CC12_Problem2 {
    
    public static void main(String[] args) {
        // Declare 2D array with dimensions 2 rows, 3 columns
        int[][] iNums = new int[2][3];
        
        // Call methods to perform operations
        fvPop(iNums);
        fvRowTotal(iNums);
        fvColTotal(iNums);
        
        int iGrand = fiGrandTotal(iNums);
        System.out.println("Grand Total: " + iGrand);
        
        int iHigh = fiHighest(iNums);
        System.out.println("Highest value: " + iHigh);
        
        fvSwapRows(iNums);
    }
    
    // Method to populate array with values
    public static void fvPop(int[][] piNums) {
        piNums[0][0] = 23;
        piNums[0][1] = 21;
        piNums[0][2] = 62;
        piNums[1][0] = 74;
        piNums[1][1] = 3;
        piNums[1][2] = 19;
    }
    
    // Method to calculate and display row totals
    public static void fvRowTotal(int[][] piNums) {
        for (int iRow = 0; iRow < piNums.length; iRow++) {
            int iRowSum = 0;
            for (int iCol = 0; iCol < piNums[iRow].length; iCol++) {
                iRowSum = iRowSum + piNums[iRow][iCol];
            }
            System.out.println("Row " + (iRow + 1) + ": " + iRowSum);
        }
    }
    
    // Method to calculate and display column totals
    public static void fvColTotal(int[][] piNums) {
        for (int iCol = 0; iCol < piNums[0].length; iCol++) {
            int iColSum = 0;
            for (int iRow = 0; iRow < piNums.length; iRow++) {
                iColSum = iColSum + piNums[iRow][iCol];
            }
            System.out.println("Col " + (iCol + 1) + ": " + iColSum);
        }
    }
    
    // Method to calculate and return grand total
    public static int fiGrandTotal(int[][] piNums) {
        int iGrandSum = 0;
        for (int iRow = 0; iRow < piNums.length; iRow++) {
            for (int iCol = 0; iCol < piNums[iRow].length; iCol++) {
                iGrandSum = iGrandSum + piNums[iRow][iCol];
            }
        }
        return iGrandSum;
    }
    
    // Method to find and return highest value
    public static int fiHighest(int[][] piNums) {
        int iHighest = piNums[0][0];
        for (int iRow = 0; iRow < piNums.length; iRow++) {
            for (int iCol = 0; iCol < piNums[iRow].length; iCol++) {
                if (piNums[iRow][iCol] > iHighest) {
                    iHighest = piNums[iRow][iCol];
                }
            }
        }
        return iHighest;
    }
    
    // Method to swap rows and display result
    public static void fvSwapRows(int[][] piNums) {
        // Swap elements between row 0 and row 1
        for (int iCol = 0; iCol < piNums[0].length; iCol++) {
            int iTemp = piNums[0][iCol];
            piNums[0][iCol] = piNums[1][iCol];
            piNums[1][iCol] = iTemp;
        }
        
        // Display the swapped rows
        for (int iRow = 0; iRow < piNums.length; iRow++) {
            System.out.print("Row " + (iRow + 1) + ": ");
            for (int iCol = 0; iCol < piNums[iRow].length; iCol++) {
                System.out.print(piNums[iRow][iCol] + " ");
            }
            System.out.println();
        }
    }
}