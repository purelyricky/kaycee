/*
 * Developer: Madubuko Divine
 * Date: 06/27/2025
 * Description: Refactored cash register using file input instead of user input
 * Original basis: CC5_Problem2 (4-item cash register)
 */

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CC7_Problem4 {
    
    public static void main(String[] args) {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        String sDataFile;
        double dSubtotal;
        
        // INPUT - Get data filename
        System.out.print("Enter filename containing item costs: ");
        sDataFile = cin.nextLine();
        
        // Call value-returning method to process file
        dSubtotal = fdProcessCashRegister(sDataFile);
        
        // Display results if file was processed successfully
        if (dSubtotal >= 0.0) {
            DecimalFormat dfCurrency = new DecimalFormat("$#,##0.00");
            double dSalesTax = dSubtotal * 0.06;
            double dTotal = dSubtotal + dSalesTax;
            
            System.out.println();
            System.out.println("Subtotal: " + dfCurrency.format(dSubtotal));
            System.out.println("Sales Tax Amount: " + dfCurrency.format(dSalesTax));
            System.out.println("Total Bill: " + dfCurrency.format(dTotal));
        }
        
        cin.close();
    }
    
    // Value-returning method to read item costs from file
    public static double fdProcessCashRegister(String psFilename) {
        try {
            // DECLARATIONS
            Scanner ifsInput = new Scanner(new File(psFilename));
            double dItemCost;
            double dSubtotal;
            int iItemCount;
            final int MAX_ITEMS = 4;
            
            // PROCESSING
            dSubtotal = 0.0;
            iItemCount = 0;
            
            System.out.println("Reading item costs from file...");
            
            while (ifsInput.hasNextDouble() && iItemCount < MAX_ITEMS) {
                dItemCost = ifsInput.nextDouble();
                iItemCount = iItemCount + 1;
                
                System.out.println("Item " + iItemCount + " cost: $" + dItemCost);
                dSubtotal = dSubtotal + dItemCost;
            }
            
            ifsInput.close();
            
            if (iItemCount == MAX_ITEMS) {
                return dSubtotal;
            } else {
                System.out.println("Error: Need exactly " + MAX_ITEMS + " items in file");
                return -1.0;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + psFilename + " not found");
            return -1.0;
        }
    }
}