/*
 * Developer: Madubuko Divine
 * Date: 06/22/2025
 * Description: Calendar display using methods and nested loops
 */

public class CC6_Problem2 {
    
    public static void main(String[] args) {
        // Loop through all 12 months
        for (int iMonth = 1; iMonth <= 12; iMonth++) {
            System.out.println("Month: " + iMonth);
            fvDayDisplay(iMonth);
        }
    }
    
    // Method to display days for a given month
    public static void fvDayDisplay(int piMonth) {
        int iMaxDays;
        
        // Determine number of days in the month using switch
        switch (piMonth) {
            case 4:  // April
            case 6:  // June
            case 9:  // September
            case 11: // November
                iMaxDays = 30;
                break;
            case 2:  // February (no leap year)
                iMaxDays = 28;
                break;
            default: // All other months have 31 days
                iMaxDays = 31;
                break;
        }
        
        // Display all days in the month
        for (int iDay = 1; iDay <= iMaxDays; iDay++) {
            System.out.println(" Day " + iDay);
        }
    }
}