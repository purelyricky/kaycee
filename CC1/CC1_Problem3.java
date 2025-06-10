/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC1_Problem3: BMI Calculator - Calculate Body Mass Index
 */

import java.util.Scanner;

public class CC1_Problem3 
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        
        double dWeightKg;
        double dHeightM;
        double dBMI;
        
        System.out.print("Enter your weight in kilograms: ");
        dWeightKg = cin.nextDouble();
        
        System.out.print("Enter your height in meters: ");
        dHeightM = cin.nextDouble();
        
        dBMI = dWeightKg / (dHeightM * dHeightM);
        
        System.out.println("Your BMI is: " + dBMI);
        System.out.println("Weight: " + dWeightKg + " kg, Height: " + dHeightM + " m");
        
        cin.close();
    }
}