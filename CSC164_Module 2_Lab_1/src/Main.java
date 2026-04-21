/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          MAY 27, 2025
 PROJECT:       MODULE 2 - LAB 1
 NOTES:         SIMPLE PROGRAM CREATED TO GET FAMILIAR WITH JAVA.

 I WROTE ALL THE CODE SUBMITTED, AND I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Declare any variables needed to run program.
        int lowThreshold;
        int highThreshold;
        int targetRange;

        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                          MODULE 2 - LAB 1                                           ");
        System.out.println("-----------------------------------------------------------------------------------------------------\n");

        // Prompt the user to enter a number to use as a low threshold.
        System.out.print("Enter a number to use as the low threshold: ");
        lowThreshold = input.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Loop created to ensure user enter a valid number for high threshold number.
        do
        {
            // Prompt the user to enter a number to use as a high threshold.
            System.out.print("\nEnter a number to use as the high threshold: ");
            highThreshold = input.nextInt();

            // Check if highThreshold is bigger than lowThershold.
            if(lowThreshold >= highThreshold)
            {
                System.out.println("\nINVALID INPUT DETECTED!\n");
                System.out.println("Please enter a number higher than " + lowThreshold);
            }

        } while(lowThreshold >= highThreshold);
        System.out.println("-----------------------------------------------------------------------------------------------------\n");


        // Loop created to ensure user enter a valid number for the 3rd number.
        do
        {
            // Prompt the user to enter a 3rd number
            System.out.print("Enter a number within the range of " + lowThreshold + " and " + highThreshold +": ");
            targetRange = input.nextInt();

            // Check to see if 3rd number is within the range of low threshold & high threshold.
            if(targetRange <= lowThreshold || targetRange >= highThreshold)
            {
                System.out.println("\nINVALID INPUT DETECTED!\n");
                System.out.println("Please ensure number entered is within the range.\n");
            }

        } while(targetRange <= lowThreshold || targetRange >= highThreshold);

        System.out.println("-----------------------------------------------------------------------------------------------------\n");
        System.out.println("Success! " + targetRange + " is within the range.");

    }
}