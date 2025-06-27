/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: File input with token counting using nested scanners
 */

import java.io.*;
import java.util.Scanner;

public class CC7_Problem2 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        String sFQFN;
        int iLineCount;
        
        // INPUT - Get filename from user
        System.out.print("Enter the fully qualified filename: ");
        sFQFN = cin.nextLine();
        
        // Call method to read file and get line count
        iLineCount = fiReadDisplayAndCountTokens(sFQFN);
        
        // OUTPUT final result
        System.out.println();
        if (iLineCount == -1) {
            System.out.println("Total lines: unable to determine; file not found");
        } else {
            System.out.println("Total lines: " + iLineCount);
        }
        
        cin.close();
    }
    
    // Value-returning method to read file, display contents, and count tokens
    public static int fiReadDisplayAndCountTokens(String psFQFN) {
        try {
            // DECLARATIONS
            Scanner ifsInput = new Scanner(new File(psFQFN));
            Scanner scTokenizer;
            String sLine;
            String sToken;
            int iLineCount;
            int iTokenCount;
            
            // Display filename
            System.out.println("File: " + psFQFN);
            System.out.println();
            
            // PROCESSING - Read file and count tokens
            iLineCount = 0;
            while (ifsInput.hasNextLine()) {
                sLine = ifsInput.nextLine();
                iLineCount = iLineCount + 1;
                
                // Count tokens in this line using nested Scanner
                scTokenizer = new Scanner(sLine);
                iTokenCount = 0;
                while (scTokenizer.hasNext()) {
                    sToken = scTokenizer.next();
                    iTokenCount = iTokenCount + 1;
                }
                scTokenizer.close();
                
                // Display line with token count
                System.out.println(sLine + " (" + iTokenCount + " tokens)");
            }
            
            ifsInput.close();
            return iLineCount;
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + psFQFN + " was not found");
            return -1;
        }
    }
}