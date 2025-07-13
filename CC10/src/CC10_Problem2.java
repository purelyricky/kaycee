/*
 * Developer: Madubuko Divine
 * Date: 07/12/2025
 * Description: CC10_Problem2: Case-insensitive string array search
 */

import java.util.Scanner;

public class CC10_Problem2 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        String[] asWords = {"tester", "James", "pill", "justice", "character", 
                           "fairness", "princess", "help", "book", "chair"};
        String sSearchWord;
        boolean bFound;
        
        // INPUT
        System.out.print("Enter a word: ");
        sSearchWord = cin.nextLine();
        
        // PROCESSING - Linear search with case-insensitive comparison
        bFound = false;
        for (int i = 0; i < asWords.length; i++) {
            if (asWords[i].equalsIgnoreCase(sSearchWord)) {
                bFound = true;
                break;
            }
        }
        
        // OUTPUT
        if (bFound) {
            System.out.println("The word '" + sSearchWord.toLowerCase() + "' was found");
        } else {
            System.out.println("The word '" + sSearchWord + "' was not found");
        }
        
        cin.close();
    }
}