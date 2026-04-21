/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JUNE 1, 2025
 PROJECT:       MODULE 4 - ASSIGNMENT 1: METHODS
 NOTES:         SPORTS SCOREKEEPER (METHODS) - PROGRAM CREATED TO HELP UNDERSTAND METHODS IN JAVA.

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
        int i;
        int menuSelect;
        float totalSeasonScore = 0;
        float averageSeasonScore = 0;
        int[] matchScore = new int[totalGames];
        int[][] teamScores = new int[totalGames][periodsPerGame];
        float[] averagePeriodScore = new float[periodsPerGame];
        float[] totalPeriodScore = new float[periodsPerGame];

        // Generate and calculate the total score for the season.
        totalSeasonScore = matchScoreCalculations(totalGames, periodsPerGame, teamScores, totalPeriodScore, matchScore, totalSeasonScore);

        // Calculate the average period score
        for (i = 0; i < periodsPerGame; i++)
            averagePeriodScore[i] = totalPeriodScore[i] / totalGames;

        // Calculate the average game score
        for (i = 0; i < totalGames; i++)
            averageSeasonScore = totalSeasonScore / totalGames;

        // Loop created to ensure program loops until user decides otherwise.
        do
        {
            // Program Banner
            menuSelect = programBanner();

            switch(menuSelect)
            {
                case 1:
                    displayMatchScoreAverage(averageSeasonScore, totalSeasonScore);
                    break;
                case 2:
                    displayPeriodScoreAverage(averagePeriodScore, totalPeriodScore, periodsPerGame);
                    break;
                case 3:
                    displayAllGames(totalGames, periodsPerGame, matchScore, teamScores);
                    break;
                case 4:
                    displaySingleGame(matchScore, teamScores);
                    break;
                case 5:
                    System.out.println("Exiting program...Goodbye.");
                    System.exit(0);
            }
        } while (true);
    }

    // Method for program Banner
    public static int programBanner()
    {
        Scanner input = new Scanner(System.in);

        // Declare any variables needed.
        int menuOption;

        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                       MODULE 4 - ASSIGNMENT 1: SPORTS SCOREKEEPER (METHODS)                          ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used to track the score for a team per season (10 game total).");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Main Menu
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
            System.out.println("\nError! Invalid input detected.\n");
            System.out.print("Enter a number from the menu to continue: ");
            menuOption = input.nextInt();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

        return menuOption;
    }

    // Method used to display average game score
    public static void displayMatchScoreAverage(float average, float total)
    {
        // Display average period scores
        System.out.println("Average score per game: " + average);
        System.out.println("Total score per season (10 games total): " + total);
    }

    // Method used to display average period score
    public static void displayPeriodScoreAverage(float[] average, float[] total, int periods)
    {
        // declare any variables needed
        int i;
        int j;

        // Display average period scores
        for (i = 0; i < periods; i++)
        {
            System.out.println("Average period " + (i+1) + " score: " + average[i]);
            System.out.println("Period " + (i+1)+ " season score (10 games total): " + total[i]);
        }
    }

    // Method used to display information for all matches.
    public static void displayAllGames(int games, int periods, int[] match, int[][] scores)
    {
        // declare any variables needed
        int i;
        int j;

        // display scores for every game
        for (i = 0; i < games; i++)
        {
            System.out.println("GAME #" + (i + 1));
            System.out.println("Final score: " + match[i]);
            for (j = 0; j < periods; j++)
            {
                System.out.println("Period " + (j+1) + " score: " + scores[i][j]);
            }
            if ((i+1) < games)
                System.out.print("\n");
        }
    }

    // Method used to display information for single match.
    public static void displaySingleGame(int[] match, int[][] period)
    {
        Scanner input = new Scanner(System.in);

        // declare any variables needed
        int gameSelect;

        System.out.print("Which game score would you like to see? (10 games total): ");
        gameSelect = input.nextInt();

        // Trap created to account for invalid input.
        while (gameSelect  < 1 || gameSelect > 10)
        {
            System.out.println("\nError! Invalid input detected.\n");
            System.out.print("Enter a game number to continue (10 games total): ");
            gameSelect = input.nextInt();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

        System.out.println("GAME #" + gameSelect);
        System.out.println("Final score: " + match[(gameSelect - 1)]);
        System.out.println("Period 1 score: " + period[(gameSelect - 1)][0]);
        System.out.println("Period 2 score: " + period[(gameSelect - 1)][1]);
    }

    // Method to assign random scores and do some calculations needed for score keeping.
    public static float matchScoreCalculations(int totalGames, int periodsPerGame, int[][] teamScores, float[] totalPeriodScore, int[] matchScore, float totalSeasonScore) {
        // Declare any variables needed.
        final int HIGH_SCORE_PER_PERIOD = 5;
        final int LOW_SCORE_PER_PERIOD = 0;
        int i;
        int j;

        Random rng = new Random();
        // Set random number generator, so it provides the same random numbers every time.
        // If you remove this line, the program will produce pseudorandom numbers that are different every time.
        rng.setSeed(0);

        // Assign random scores to each period for each game and calculate the totals.
        for (i = 0; i < totalGames; i++) {
            for (j = 0; j < periodsPerGame; j++) {
                // Assign random score
                teamScores[i][j] = rng.nextInt(LOW_SCORE_PER_PERIOD, HIGH_SCORE_PER_PERIOD + 1);

                // Calculate total score per period.
                totalPeriodScore[j] += teamScores[i][j];

                // Calculate total score per game.
                matchScore[i] += teamScores[i][j];

                // Calculate total score per season.
                totalSeasonScore += teamScores[i][j];
            }
        }
        return totalSeasonScore;
    }
}
