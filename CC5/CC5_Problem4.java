/*
 * Developer: [Your Name]
 * Date: 06/14/2025
 * Description: CC5_Problem4: Acronym builder using String class and tokenizing
 */

import java.util.Scanner;

public class CC5_Problem4 {
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        Scanner tokenScanner;
        String sInputPhrase;
        String sAcronym;
        String sToken;
        String sFirstLetter;
        String sIncludeMinor;
        boolean bIncludeMinorWords;
        
        // INPUT
        System.out.print("Enter a phrase to create an acronym for: ");
        sInputPhrase = cin.nextLine();
        
        // Process input
        sInputPhrase = sInputPhrase.toUpperCase().trim();
        
        // Validate input
        if (sInputPhrase.length() < 1) {
            System.out.println("Error: You didn't type anything");
            cin.close();
            return;
        }
        
        // Ask about minor words
        System.out.print("Include minor words of, for, and, by, with? Y or N: ");
        sIncludeMinor = cin.nextLine().toUpperCase().trim();
        bIncludeMinorWords = sIncludeMinor.equals("Y");
        
        // PROCESSING
        sAcronym = ""; // Initialize acronym string
        tokenScanner = new Scanner(sInputPhrase);
        
        while (tokenScanner.hasNext()) {
            sToken = tokenScanner.next().trim();
            
            // Check if we should skip minor words
            if (!bIncludeMinorWords) {
                if (sToken.equals("OF") || sToken.equals("FOR") || 
                    sToken.equals("AND") || sToken.equals("BY") || 
                    sToken.equals("WITH")) {
                    continue; // Skip this token
                }
            }
            
            // Get first letter and append to acronym
            sFirstLetter = sToken.substring(0, 1);
            sAcronym = sAcronym + sFirstLetter;
        }
        
        // OUTPUT
        System.out.println("Acronym: " + sAcronym);
        
        tokenScanner.close();
        cin.close();
    }
}