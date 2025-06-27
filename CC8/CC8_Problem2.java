/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Player vs Computer guessing game with enhanced odds
 * 
 * AI Research Summary:
 * I consulted ChatGPT and claude about improving computer win rates.
 * They both suggested using weighted probability distributions and biasing toward
 * recently chosen numbers.
 * 
 * I implemented a bias factor that makes the computer more likely to guess
 * numbers closer to the player's previous choices, giving the house a better edge.
 * ChatGPT provided clearer explanations and more practical implementation advice.
 * 
 * Chat links: https://chatgpt.com/share/685efb93-ecdc-800d-9b72-dcfad08fb445
 *             https://claude.ai/share/3b997593-49dc-4d75-8f22-3b5255335c10
 */

import java.util.Scanner;
import java.util.Random;

public class CC8_Problem2 {
    
    // Global constants
    public static final int giMIN = 1;
    public static final int giMAX = 10;
    public static final double gdBIAS_FACTOR = 0.3; // Computer advantage factor
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        int iPlayerGuess;
        int iComputerGuess;
        int iPlayerWins;
        int iComputerWins;
        int iRoundNumber;
        int iLastPlayerGuess;
        
        // INITIALIZE
        iPlayerWins = 0;
        iComputerWins = 0;
        iRoundNumber = 1;
        iLastPlayerGuess = (giMIN + giMAX) / 2; // Start with middle value
        
        // Welcome message
        System.out.println("Welcome to Madubuko's Game of Thorns");
        
        // PROCESSING - do-while loop for game
        do {
            System.out.println();
            System.out.println("Round " + iRoundNumber + ": Player " + iPlayerWins + 
                             ", Computer " + iComputerWins);
            System.out.print("Enter a number from " + giMIN + " to " + giMAX + 
                           ", negative number to quit: ");
            iPlayerGuess = cin.nextInt();
            
            if (iPlayerGuess > giMAX) {
                System.out.println("Player's guess is out of range. Max is " + giMAX + 
                                 ", Min is " + giMIN + ". Try again.");
                continue; // Don't increment round number
            }
            
            if (iPlayerGuess >= giMIN && iPlayerGuess <= giMAX) {
                // Generate computer guess with bias toward player's patterns
                iComputerGuess = fiGenerateSmartGuess(iLastPlayerGuess);
                iLastPlayerGuess = iPlayerGuess; // Remember for next round
                
                System.out.println("Player chose " + iPlayerGuess + ", computer guessed " + 
                                 iComputerGuess + ", " + 
                                 (iPlayerGuess == iComputerGuess ? "computer won." : "player won."));
                
                // Update win counters
                if (iPlayerGuess == iComputerGuess) {
                    iComputerWins = iComputerWins + 1;
                } else {
                    iPlayerWins = iPlayerWins + 1;
                }
                
                iRoundNumber = iRoundNumber + 1;
            } else if (iPlayerGuess < 0) {
                // Handle negative input (exit condition)
                iComputerGuess = fiGenerateSmartGuess(iLastPlayerGuess);
                System.out.println("Player chose " + iPlayerGuess + ", computer guessed " + 
                                 iComputerGuess + ", player won.");
                iPlayerWins = iPlayerWins + 1;
                break;
            }
            
        } while (iPlayerGuess >= 0);
        
        System.out.println();
        System.out.println("Game Over");
        
        cin.close();
    }
    
    // Enhanced computer guessing method with bias
    public static int fiGenerateSmartGuess(int piLastPlayerGuess) {
        Random rand = new Random();
        
        // Use bias to make computer guess closer to player's patterns
        if (rand.nextDouble() < gdBIAS_FACTOR) {
            // Bias toward player's last guess +/- 1
            int iBiasedGuess = piLastPlayerGuess + (rand.nextBoolean() ? 1 : -1);
            
            // Ensure it's within valid range
            if (iBiasedGuess >= giMIN && iBiasedGuess <= giMAX) {
                return iBiasedGuess;
            }
        }
        
        // Default random guess
        return rand.nextInt(giMAX - giMIN + 1) + giMIN;
    }
}