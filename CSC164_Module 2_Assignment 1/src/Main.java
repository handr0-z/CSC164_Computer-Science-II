/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          MAY 27, 2025
 PROJECT:       MODULE 2 - ASSIGNMENT 1:
 NOTES:         SPORTS SCOREKEEPER - A SIMPLE PROGRAM CREATED TO GET FAMILIAR WITH JAVA.

 I WROTE ALL THE CODE SUBMITTED, AND I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Declare any variables needed to run the program.
        int i = 0;
        double[] score = new double[5];
        double totalPoints = 0;
        double averageScore = 0;

        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                            MODULE 2 - ASSIGNMENT 1: SPORTS SCOREKEEPER                              ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used to calculate the average points per game for a team.");
        System.out.println("-----------------------------------------------------------------------------------------------------\n");

        // Loop created to obtain game scores from user.
        for (i = 0; i<5; i++)
        {
            System.out.print("Enter score for game " + (i + 1) + ": ");
            score[i] = input.nextDouble();

            // Verify that score provided is not a negative value.
            if(score[i] < 0)
            {
                do
                {
                    System.out.println("\nError! Invalid Input Detected.\n");
                    System.out.println("Score cannot be a negative number!\n");
                    System.out.print("Enter score for game " + (i + 1) + ": ");
                    score[i] = input.nextDouble();
                } while(score[i] < 0);
            }

            // Calculate the average points per game based on scores entered.
            totalPoints += score[i];
            averageScore = (totalPoints/ (i + 1));
            System.out.println("-----------------------------------------------------------------------------------------------------\n");
        }

        // Display the average points per game.
        System.out.println("Total # of games played: 5\n");
        System.out.println("Total points earned: " + totalPoints + "\n");
        System.out.println("Average points earned per game: " + averageScore);
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}
