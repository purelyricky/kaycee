/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC3_Problem1: Floating-point comparison using == vs epsilon method
 */

public class CC3_Problem1 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        double dCalculatedSum;
        double dActualSum;
        double dDifference;
        double dEpsilon;
        
        // PROCESSING AND CALCULATIONS
        dCalculatedSum = 0.1 + 0.2 + 0.3;
        dActualSum = 0.6;
        dDifference = dCalculatedSum - dActualSum;
        
        // OUTPUT - Display values without formatting
        System.out.println("Calculated sum: " + dCalculatedSum);
        System.out.println("Actual sum: " + dActualSum);
        System.out.println("Calculated sum -- actual sum: " + dDifference);
        
        // First comparison using == operator (double-selection if)
        if (dActualSum == dCalculatedSum)
        {
            System.out.println("The comparison evaluates to EQUAL using ==");
        }
        else
        {
            System.out.println("The comparison evaluates to NOT EQUAL using ==");
        }
        
        // Initialize epsilon value
        dEpsilon = 0.001;
        
        // Second comparison using epsilon method (double-selection if)
        if (Math.abs(dActualSum - dCalculatedSum) < dEpsilon)
        {
            System.out.println("The comparison is CLOSE ENOUGH TO BE CONSIDERED NEARLY EQUAL at .001 epsilon");
        }
        else
        {
            System.out.println("The comparison is NOT CLOSE ENOUGH TO BE CONSIDERED NEARLY EQUAL at .001 epsilon");
        }
    }
}