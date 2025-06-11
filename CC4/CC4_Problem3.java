/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC4_Problem3: DC SFRA gate and frequency selector based on radial
 */

import java.util.Scanner;

public class CC4_Problem3 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        int iRadial;
        
        // INPUT
        System.out.print("Enter radial: ");
        iRadial = cin.nextInt();
        
        // PROCESSING AND OUTPUT
        if (iRadial < 1 || iRadial > 360)
        {
            System.out.println("Invalid radial: range is 1 and 360");
        }
        else if ((iRadial >= 341 && iRadial <= 360) || (iRadial >= 1 && iRadial <= 46))
        {
            System.out.println("Use WOOLY on 132.775");
        }
        else if (iRadial >= 47 && iRadial <= 119)
        {
            System.out.println("Use PALEO on 132.775");
        }
        else if (iRadial >= 120 && iRadial <= 172)
        {
            System.out.println("Use WHINO on 125.125");
        }
        else if (iRadial >= 173 && iRadial <= 214)
        {
            System.out.println("Use GRUBY on 125.125");
        }
        else if (iRadial >= 215 && iRadial <= 236)
        {
            System.out.println("Use BRV on 127.325");
        }
        else if (iRadial >= 237 && iRadial <= 269)
        {
            System.out.println("Use FLUKY on 127.325");
        }
        else if (iRadial >= 270 && iRadial <= 309)
        {
            System.out.println("Use JASEN on 127.325");
        }
        else if (iRadial >= 310 && iRadial <= 340)
        {
            System.out.println("Use LUCKE on 127.325");
        }
        
        cin.close();
    }
}