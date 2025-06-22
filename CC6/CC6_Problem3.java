/*
 * Developer: Madubuko Divine
 * Date: 06/22/2025
 * Description:HTML table generator using methods and nested loops
 */

import java.util.Scanner;

public class CC6_Problem3 {
    
    // Global constant for line breaks
    public static final String gsCRLF = String.valueOf((char) 13) + String.valueOf((char) 10);
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        int iMaxRows;
        int iMaxCols;
        String sWebPage;
        
        // INPUT
        System.out.print("Enter number of rows desired (1-19): ");
        iMaxRows = cin.nextInt();
        
        System.out.print("Enter number of columns desired (1-5): ");
        iMaxCols = cin.nextInt();
        
        // VALIDATION AND PROCESSING
        if (iMaxRows > 0 && iMaxRows < 20 && iMaxCols > 0 && iMaxCols < 6) {
            // Call method to generate HTML table
            sWebPage = fsMakeHTMLTable(iMaxRows, iMaxCols);
            
            // Display the HTML code
            System.out.println(sWebPage);
            System.out.println();
            System.out.println("Copy and paste the above output into CC6_Problem3.htm and open in browser");
        } else {
            System.out.println("Error: Rows must be 1-19 and columns must be 1-5");
        }
        
        cin.close();
    }
    
    // Method to create HTML table
    public static String fsMakeHTMLTable(int piMaxRows, int piMaxCols) {
        String sOut;
        
        // Initialize output string
        sOut = "";
        
        // HTML header and beginning
        sOut = sOut + "<html>" + gsCRLF;
        sOut = sOut + "<body>" + gsCRLF;
        sOut = sOut + "<style>" + gsCRLF;
        sOut = sOut + "body" + gsCRLF;
        sOut = sOut + "{" + gsCRLF;
        sOut = sOut + "font-family: Arial, Helvetica, sans-serif;" + gsCRLF;
        sOut = sOut + "}" + gsCRLF;
        sOut = sOut + "</style>" + gsCRLF;
        sOut = sOut + "<h2>Madubuko Divine CC6 Problem 3</h2>" + gsCRLF;
        sOut = sOut + "<table border = 1>" + gsCRLF;
        
        // Generate table rows and columns using nested loops
        for (int iRow = 0; iRow < piMaxRows; iRow++) {
            // Determine row color (alternating)
            if (iRow % 2 == 0) {
                sOut = sOut + "<tr bgcolor = 'Lime'>" + gsCRLF;
            } else {
                sOut = sOut + "<tr bgcolor = 'DodgerBlue'>" + gsCRLF;
            }
            
            // Generate columns for this row
            for (int iCol = 0; iCol < piMaxCols; iCol++) {
                sOut = sOut + "<td>Row " + iRow + " : Column " + iCol + "</td>" + gsCRLF;
            }
            
            sOut = sOut + "</tr>" + gsCRLF;
        }
        
        // HTML ending
        sOut = sOut + "</table>" + gsCRLF;
        sOut = sOut + "</body>" + gsCRLF;
        sOut = sOut + "</html>" + gsCRLF;
        
        return sOut;
    }
}