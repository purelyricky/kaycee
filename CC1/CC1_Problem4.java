/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC1_Problem4: Aircraft descent calculation
 */

import java.util.Scanner;

public class CC1_Problem4 
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        
        double dCruiseAltitude;
        double dTargetAltitude;
        double dAirspeed;
        double dDescentRate;
        double dAltitudeDifference;
        double dDescentTimeMinutes;
        double dDescentTimeHours;
        double dDistance;
        
        System.out.print("Cruise altitude: ");
        dCruiseAltitude = cin.nextDouble();
        
        System.out.print("Target altitude: ");
        dTargetAltitude = cin.nextDouble();
        
        System.out.print("Airspeed: ");
        dAirspeed = cin.nextDouble();
        
        System.out.print("Descent rate: ");
        dDescentRate = cin.nextDouble();
        
        dAltitudeDifference = dCruiseAltitude - dTargetAltitude;
        dDescentTimeMinutes = dAltitudeDifference / dDescentRate;
        dDescentTimeHours = dDescentTimeMinutes / 60.0;
        dDistance = dAirspeed * dDescentTimeHours;
        
        System.out.println("Cruise altitude: " + dCruiseAltitude + " feet");
        System.out.println("Target altitude: " + dTargetAltitude + " feet");
        System.out.println("Airspeed: " + dAirspeed + " knots");
        System.out.println("Descent rate: " + dDescentRate + " feet/minute");
        System.out.println("Time needed to descend: " + (int)dDescentTimeMinutes + " minutes (or raw, " + dDescentTimeMinutes + "...)");
        System.out.println("Distance to begin descent: " + (int)dDistance + " nautical miles (or raw, " + dDistance + "...)");
        
        cin.close();
    }
}