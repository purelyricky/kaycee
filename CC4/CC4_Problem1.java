/*
 * Developer: Madubuko Divine
 * Date: 06/10/2025
 * Description: CC4_Problem1: Email address validation using composite error string builder
 */

import java.util.Scanner;

public class CC4_Problem1 
{
    public static void main(String[] args) 
    {
        // DECLARATIONS
        Scanner cin = new Scanner(System.in);
        String sEmail;
        String sErrMsg;
        String sLocalPart;
        String sDomainPart;
        String sAfterFirstAt;
        int iAtPosition;
        
        // INPUT
        System.out.print("Enter an email address: ");
        sEmail = cin.nextLine();
        
        // PROCESSING - Initialize error message string
        sErrMsg = "";
        
        // Test 1: String length validation (5 to 320 characters)
        if (sEmail.length() < 5 || sEmail.length() > 320)
        {
            sErrMsg = sErrMsg + "Error: Invalid length" + (char) 13 + (char) 10;
        }
        
        // Find position of first @ symbol for subsequent tests
        iAtPosition = sEmail.indexOf("@");
        
        // Test 2: Contains only one @ symbol
        if (iAtPosition != -1) // @ symbol found
        {
            sAfterFirstAt = sEmail.substring(iAtPosition + 1);
            if (sAfterFirstAt.contains("@"))
            {
                sErrMsg = sErrMsg + "Error: More than one @ found" + (char) 13 + (char) 10;
            }
        }
        else
        {
            sErrMsg = sErrMsg + "Error: No @ symbol found" + (char) 13 + (char) 10;
        }
        
        // Test 3: Local part length validation (1 to 64 characters)
        if (iAtPosition != -1)
        {
            sLocalPart = sEmail.substring(0, iAtPosition);
            if (sLocalPart.length() > 64)
            {
                sErrMsg = sErrMsg + "Error: More than 64 characters to the left of the @ symbol" + (char) 13 + (char) 10;
            }
        }
        
        // Test 4: Top-level domain validation
        if (iAtPosition != -1)
        {
            sDomainPart = sEmail.substring(iAtPosition + 1);
            if (!sDomainPart.endsWith(".com") && !sDomainPart.endsWith(".org") && 
                !sDomainPart.endsWith(".net") && !sDomainPart.endsWith(".edu") && 
                !sDomainPart.endsWith(".gov") && !sDomainPart.endsWith(".tv") && 
                !sDomainPart.endsWith(".mx"))
            {
                sErrMsg = sErrMsg + "Error: The top-level domain is invalid" + (char) 13 + (char) 10;
            }
        }
        
        // OUTPUT - Display results
        if (sErrMsg.equals(""))
        {
            System.out.println("Email address is okay for the tests I picked");
        }
        else
        {
            System.out.print(sErrMsg);
        }
        
        cin.close();
    }
}