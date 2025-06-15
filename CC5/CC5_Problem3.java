/*
 * Developer: [Your Name]
 * Date: 06/14/2025
 * Description: CC5_Problem3: Cash register for unlimited items using sentinel-controlled loop
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CC5_Problem3 {
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
        
        double dItemCost;
        double dSubtotal;
        double dSalesTax;
        double dTotal;
        int iItemCount;
        
        final double SALES_TAX_RATE = 0.06; // 6% sales tax
        
        // INITIALIZE
        dSubtotal = 0.0;
        iItemCount = 0;
        
        // PROCESSING - Sentinel-controlled while loop
        System.out.print("Enter item 1 cost, negative to quit: ");
        dItemCost = cin.nextDouble();
        
        while (dItemCost >= 0.0) { // Continue while cost is not negative
            dSubtotal = dSubtotal + dItemCost;
            iItemCount = iItemCount + 1;
            
            System.out.print("Enter item " + (iItemCount + 1) + " cost, negative to quit: ");
            dItemCost = cin.nextDouble();
        }
        
        // OUTPUT
        System.out.println();
        if (iItemCount == 0) {
            System.out.println("No items to process");
        } else {
            dSalesTax = dSubtotal * SALES_TAX_RATE;
            dTotal = dSubtotal + dSalesTax;
            
            System.out.println("Number of Items: " + iItemCount);
            System.out.println("Subtotal: " + dfCurrency.format(dSubtotal));
            System.out.println("Sales Tax Amount: " + dfCurrency.format(dSalesTax));
            System.out.println("Total Bill: " + dfCurrency.format(dTotal));
        }
        
        cin.close();
    }
}