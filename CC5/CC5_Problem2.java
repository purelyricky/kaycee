/*
 * Developer: Madubuko Divine
 * Date: 06/14/2025
 * Description: CC5_Problem2: Cash register for exactly 4 items using while loop
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC5_Problem2 {
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
        
        double dItemCost;
        double dSubtotal;
        double dSalesTax;
        double dTotal;
        int iCounter;
        
        final double SALES_TAX_RATE = 0.06; // 6% sales tax
        final int MAX_ITEMS = 4;
        
        // INITIALIZE
        dSubtotal = 0.0;
        iCounter = 1; // Initialize counter
        
        // PROCESSING - Counter-controlled while loop
        while (iCounter <= MAX_ITEMS) { // Test condition
            System.out.print("Item " + iCounter + " cost: ");
            dItemCost = cin.nextDouble();
            
            dSubtotal = dSubtotal + dItemCost; // Accumulate subtotal
            
            iCounter = iCounter + 1; // Manage counter
        }
        
        // Calculate tax and total
        dSalesTax = dSubtotal * SALES_TAX_RATE;
        dTotal = dSubtotal + dSalesTax;
        
        // OUTPUT
        System.out.println();
        System.out.println("Subtotal: " + dfCurrency.format(dSubtotal));
        System.out.println("Sales Tax Amount: " + dfCurrency.format(dSalesTax));
        System.out.println("Total Bill: " + dfCurrency.format(dTotal));
        
        cin.close();
    }
}