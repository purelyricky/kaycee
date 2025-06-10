/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC3_Problem3: Overtime pay calculator
 */

import java.text.*;
import java.util.Scanner;

public class CC3_Problem3 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        // Input-capture variables
        double dRegularRate;
        double dTotalHours;
        
        // Expression-result variables
        double dRegularHours;
        double dOvertimeHours;
        double dOvertimeRate;
        double dRegularPay;
        double dOvertimePay;
        double dTotalPay;
        
        // Scanner instantiation
        Scanner cin = new Scanner(System.in);
        
        // DecimalFormat instantiation
        DecimalFormat dfCurrency = new DecimalFormat("$###.00");
        DecimalFormat dfHours = new DecimalFormat("##.00");
        
        // INPUT
        System.out.print("Regular hourly pay rate: ");
        dRegularRate = cin.nextDouble();
        
        System.out.print("Total hours worked: ");
        dTotalHours = cin.nextDouble();
        
        // PROCESSING AND CALCULATIONS
        dOvertimeRate = dRegularRate * 1.5;
        
        if (dTotalHours <= 40.0)
        {
            // No overtime
            dRegularHours = dTotalHours;
            dOvertimeHours = 0.0;
            dRegularPay = dRegularHours * dRegularRate;
            dOvertimePay = 0.0;
        }
        else
        {
            // Overtime applies
            dRegularHours = 40.0;
            dOvertimeHours = dTotalHours - 40.0;
            dRegularPay = dRegularHours * dRegularRate;
            dOvertimePay = dOvertimeHours * dOvertimeRate;
        }
        
        dTotalPay = dRegularPay + dOvertimePay;
        
        // OUTPUT - All output after the if block
        System.out.println("Total hours worked: " + dfHours.format(dTotalHours));
        System.out.println("Overtime hours worked: " + dfHours.format(dOvertimeHours));
        System.out.println();
        System.out.println("Regular pay rate: " + dfCurrency.format(dRegularRate));
        System.out.println("Overtime pay rate: " + dfCurrency.format(dOvertimeRate));
        System.out.println();
        System.out.println("Regular gross pay: " + dfCurrency.format(dRegularPay));
        System.out.println("Overtime gross pay: " + dfCurrency.format(dOvertimePay));
        System.out.println("Total gross pay: " + dfCurrency.format(dTotalPay));
        
        cin.close();
    }
}