/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          MAY 31, 2025
 PROJECT:       MODULE 3 - ASSIGNMENT 1:
 NOTES:         SPORTS SCOREKEEPER (ARRAYS) - PROGRAM CREATED TO HELP UNDERSTAND ARRAYS IN JAVA.

 ASIDE FROM THE STARTER CODE PROVIDED FOR THIS ASSIGNMENT, I WROTE ALL THE CODE SUBMITTED.
 OTHERWISE, I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

// Import any methods needed for program.
import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        // Declare any variables required to run the program.
        final int totalGames = 10;
        final int periodsPerGame = 2;
        final int HIGH_SCORE_PER_PERIOD = 5;
        final int LOW_SCORE_PER_PERIOD = 0;
        int i;
        int j;
        int menuOption;
        int gameSelect;
        int totalSeasonScore = 0;
        int[] totalPeriodScore = new int[periodsPerGame];
        float averageSeasonScore = 0;
        float[] averagePeriodScore = new float[periodsPerGame];
        int[] matchScore = new int[totalGames];
        int[][] teamScores = new int[totalGames][periodsPerGame];

        Scanner input = new Scanner(System.in);
        Random rng = new Random();
        // Set random number generator, so it provides the same random numbers every time.
        // If you remove this line, the program will produce pseudorandom numbers that are different every time.
        rng.setSeed(0);

        // Assign random scores to each period for each game and calculate the totals.
        for (i = 0; i < totalGames; i++)
        {
            for (j = 0; j < periodsPerGame; j++)
            {
                // Assign random score
                teamScores[i][j] = rng.nextInt(LOW_SCORE_PER_PERIOD, HIGH_SCORE_PER_PERIOD+1);

                // Calculate total score per period.
                totalPeriodScore[j] += teamScores[i][j];

                // Calculate total score per game.
                matchScore[i] += teamScores[i][j];

                // Calculate total score per season.
                totalSeasonScore += teamScores[i][j];
            }
        }

        // Calculate the average period score
        for (i = 0; i < periodsPerGame; i++)
            averagePeriodScore[i] = (float) totalPeriodScore[i] / totalGames;

        // Calculate the average game score
        for (i = 0; i < totalGames; i++)
            averageSeasonScore = (float) totalSeasonScore / totalGames;

        do
        {
            // Program Banner
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
            System.out.println("                         MODULE 3 - ASSIGNMENT 1: SPORTS SCOREKEEPER ARRAYS                          ");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("This program can be used to track the score for a team per season (10 game total).");
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Main menu for user to select what to do with program.
            System.out.println("What would you like to view?");
            System.out.println("1) Display average score per game");
            System.out.println("2) Display average score per period");
            System.out.println("3) Display all game Scores");
            System.out.println("4) Display single game score");
            System.out.println("5) Exit program\n");
            System.out.print("Enter a number to confirm option: ");
            menuOption = input.nextInt();

            // Trap created to account for invalid input.
            while (menuOption  < 1 || menuOption >5)
            {
                System.out.println("Error! Invalid input detected.");
                System.out.print("Enter a number from the menu to continue: ");
                menuOption = input.nextInt();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");

            if (menuOption == 1)
            {
                // Display average period scores
                System.out.println("Average score per game: " + averageSeasonScore);
                System.out.println("Total score per season (10 games total): " + totalSeasonScore);
            }
            else if (menuOption == 2)
            {
                // Display average period scores
                for (i = 0; i < periodsPerGame; i++)
                {
                    System.out.println("Average period " + (i+1) + " score: " + averagePeriodScore[i]);
                    System.out.println("Period " + (i+1)+ " season score (10 games total): " + totalPeriodScore[i]);
                }
            }
            else if (menuOption == 3)
            {
                // display scores for every game
                for (i = 0; i < totalGames; i++)
                {
                    System.out.println("GAME #" + (i + 1));
                    System.out.println("Final score: " + matchScore[i]);
                    for (j = 0; j < periodsPerGame; j++)
                    {
                        System.out.println("Period " + (j+1) + " score: " + teamScores[i][j]);
                    }
                    if ((i+1) < totalGames)
                        System.out.println("");
                }
            }
            else if (menuOption == 4)
            {
                System.out.print("Which game score would you like to see? (10 games total): ");
                gameSelect = input.nextInt();

                // Trap created to account for invalid input.
                while (gameSelect  < 1 || gameSelect > 10)
                {
                    System.out.println("Error! Invalid input detected.");
                    System.out.print("Enter a game number to continue (10 games total): ");
                    gameSelect = input.nextInt();
                    System.out.println("");
                }
                System.out.println("-----------------------------------------------------------------------------------------------------");

                System.out.println("GAME #" + gameSelect);
                System.out.println("Final score: " + matchScore[(gameSelect - 1)]);
                System.out.println("Period 1 score: " + teamScores[(gameSelect - 1)][0]);
                System.out.println("Period 2 score: " + teamScores[(gameSelect - 1)][1]);
            }
            else
            {
                System.out.println("Exiting program...Goodbye.");
                System.exit(0);
            }
        } while (true);

    }
}
