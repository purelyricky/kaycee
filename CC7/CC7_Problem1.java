/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: File input with line numbering using value-returning method
 */

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CC7_Problem1 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        String sFQFN;
        int iLineCount;
        
        // Hard-coded filename
        sFQFN = "Lab_7_Data.txt";
        
        // Call method to read file and get line count
        iLineCount = fiReadAndDisplayFile(sFQFN);
        
        // OUTPUT final result
        System.out.println();
        if (iLineCount == -1) {
            System.out.println("Total lines: unable to determine; file not found");
        } else {
            System.out.println("Total lines: " + iLineCount);
        }
    }
    
    // Value-returning method to read file and display contents
    public static int fiReadAndDisplayFile(String psFQFN) {
        try {
            // DECLARATIONS
            Scanner ifsInput = new Scanner(new File(psFQFN));
            String sLine;
            int iLineCount;
            DecimalFormat dfPad3 = new DecimalFormat("000");
            
            // Display filename
            System.out.println("File: " + psFQFN);
            System.out.println();
            
            // PROCESSING - Read and display file contents
            iLineCount = 0;
            while (ifsInput.hasNextLine()) {
                sLine = ifsInput.nextLine();
                iLineCount = iLineCount + 1;
                System.out.println(dfPad3.format(iLineCount) + ": " + sLine);
            }
            
            ifsInput.close();
            return iLineCount;
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + psFQFN + " was not found");
            return -1;
        }
    }
}