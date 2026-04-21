/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          MAY 31, 2025
 PROJECT:       MODULE 3 - LAB 1: ARRAYS
 NOTES:         A SIMPLE PROGRAM CREATED TO GET FAMILIAR WITH ARRAYS IN JAVA.

 I WROTE ALL THE CODE SUBMITTED, AND I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                       MODULE 3 - LAB 1: ARRAYS                                      ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used to store the number of cars sold by a dealership each month.");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Declare any variables needed to run the program.
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] soldCars = new int[12];
        int i;

        // Prompt the user to input the number of cars sold each month.
        for (i = 0; i<12; i++)
        {
            System.out.print("How many cars were sold in " + months[i] + "? ");
            soldCars[i] = input.nextInt();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Display the numbers of cars sold per month
        for (i =0; i<12; i++)
        {
            System.out.print("Cars sold in " + months[i] + ": " + soldCars[i]);
            if (soldCars[i] >= 20)
                System.out.println(" ** Extra 10% commission");
            else
                System.out.println("");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");20
    }

}
