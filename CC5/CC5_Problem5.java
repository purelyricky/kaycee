/*
 * Developer: Madubuko Divine
 * Date: 06/14/2025
 * Description: CC5_Problem5: Compound interest calculator with chart
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC5_Problem5 {
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
        DecimalFormat dfPercent = new DecimalFormat("0.00%");
        
        double dPrincipal;
        double dInterestRate;
        int iCompoundingPeriods;
        int iYears;
        double dBalance;
        double dTotalInterest;
        int iPeriod;
        
        // INPUT AND VALIDATION
        System.out.print("Enter initial principal amount: $");
        dPrincipal = cin.nextDouble();
        if (dPrincipal <= 0) {
            System.out.println("Error: Principal must be positive");
            cin.close();
            return;
        }
        
        System.out.print("Enter annual interest rate (as decimal, e.g., 0.05 for 5%): ");
        dInterestRate = cin.nextDouble();
        if (dInterestRate <= 0 || dInterestRate > 1) {
            System.out.println("Error: Interest rate must be between 0 and 1");
            cin.close();
            return;
        }
        
        System.out.print("Enter number of times interest compounds per year: ");
        iCompoundingPeriods = cin.nextInt();
        if (iCompoundingPeriods <= 0) {
            System.out.println("Error: Compounding periods must be positive");
            cin.close();
            return;
        }
        
        System.out.print("Enter number of years: ");
        iYears = cin.nextInt();
        if (iYears <= 0) {
            System.out.println("Error: Years must be positive");
            cin.close();
            return;
        }
        
        // PROCESSING AND OUTPUT
        System.out.println("\n=== COMPOUND INTEREST CHART ===");
        System.out.println("Principal: " + dfCurrency.format(dPrincipal));
        System.out.println("Interest Rate: " + dfPercent.format(dInterestRate));
        System.out.println("Compounding: " + iCompoundingPeriods + " times per year");
        System.out.println("Duration: " + iYears + " years");
        System.out.println();
        
        System.out.printf("%-8s %-12s%n", "Period", "Balance");
        System.out.println("--------------------");
        
        dBalance = dPrincipal;
        int iTotalPeriods = iYears * iCompoundingPeriods;
        
        // Display initial balance
        System.out.printf("%-8d %-12s%n", 0, dfCurrency.format(dBalance));
        
        // Calculate and display balance for each period
        for (iPeriod = 1; iPeriod <= iTotalPeriods; iPeriod++) {
            dBalance = dBalance * (1.0 + (dInterestRate / iCompoundingPeriods));
            System.out.printf("%-8d %-12s%n", iPeriod, dfCurrency.format(dBalance));
        }
        
        // SUMMARY
        dTotalInterest = dBalance - dPrincipal;
        System.out.println();
        System.out.println("=== SUMMARY ===");
        System.out.println("Starting Principal: " + dfCurrency.format(dPrincipal));
        System.out.println("Ending Balance: " + dfCurrency.format(dBalance));
        System.out.println("Total Interest Earned: " + dfCurrency.format(dTotalInterest));
        System.out.println("Total Return: " + dfPercent.format((dBalance - dPrincipal) / dPrincipal));
        
        cin.close();
    }
}