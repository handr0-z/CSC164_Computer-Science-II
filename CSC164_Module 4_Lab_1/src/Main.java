import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            int[] soldCars = new int[]{13, 11, 25, 31, 19, 20, 21, 26, 34, 18, 32, 9};
            int[] commissionEarnedByMonth = new int[12];
            Scanner input = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("                                      ALEJANDRO PANTOJA-ZURITA                                       ");
            System.out.println("                                      MODULE 4 - LAB 1: METHODS                                      ");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("This program can be used to store the number of cars sold by a dealership each month and calculate   ");
            System.out.println("commission earned each month.");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("What would you like to view?");
            System.out.println("1) Display all sales for the year");
            System.out.println("2) Display sales by month");
            System.out.println("3) Display commission earned by month");
            System.out.println("4) Exit program\n");
            System.out.print("Enter a number to confirm option: ");

            int menuOption;
            for(menuOption = input.nextInt(); menuOption < 1 || menuOption > 4; menuOption = input.nextInt()) {
                System.out.println("\nError! Invalid input detected.\n");
                System.out.print("Enter a number from the menu to continue: ");
            }

            System.out.println("-----------------------------------------------------------------------------------------------------");
            calculateCommissionEarned(soldCars, commissionEarnedByMonth);
            switch (menuOption) {
                case 1:
                    showAllASale(soldCars, months, commissionEarnedByMonth);
                    break;
                case 2:
                    System.out.print("What month (1-12) would you like to view? ");

                    int monthSelect;
                    for(monthSelect = input.nextInt(); monthSelect < 1 || monthSelect > 12; monthSelect = input.nextInt()) {
                        System.out.println("\nError! Invalid input detected.\n");
                        System.out.print("What month (1-12) would you like to view? ");
                    }

                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    showSalesByMonth(soldCars, months, monthSelect);
                    break;
                case 3:
                    System.out.print("What month (1-12) would you like to view? ");

                    for(monthSelect = input.nextInt(); monthSelect < 1 || monthSelect > 12; monthSelect = input.nextInt()) {
                        System.out.println("\nError! Invalid input detected.\n");
                        System.out.print("What month (1-12) would you like to view? ");
                    }

                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    showCommissionByMonth(commissionEarnedByMonth, months, monthSelect, soldCars);
                    break;
                case 4:
                    System.out.println("Exiting program...Goodbye.");
                    System.exit(0);
            }
        }
    }

    public static void showAllASale(int[] cars, String[] month, int[] commission) {
        for(int i = 0; i < 12; ++i) {
            System.out.println(month[i] + ": " + cars[i] + " Cars sold.");
            System.out.printf("Commission earned: $" + commission[i] + ".00\n");
            if (cars[i] >= 20) {
                System.out.println("- Extra 10% commission -\n");
            } else {
                System.out.print("\n");
            }
        }

    }

    public static void showSalesByMonth(int[] cars, String[] month, int i) {
        System.out.println(month[i - 1] + ": " + cars[i - 1] + " Cars sold.");
    }

    public static void showCommissionByMonth(int[] commission, String[] month, int i, int[] cars) {
        System.out.println("Commission earned in " + month[i - 1] + ": $" + commission[i - 1] + ".00");
        if (cars[i - 1] >= 20) {
            System.out.println("- Extra 10% commission -");
        }

    }

    public static void calculateCommissionEarned(int[] cars, int[] commission) {
        for(int i = 0; i < 12; ++i) {
            if (cars[i] <= 20) {
                commission[i] = cars[i] * 500;
            } else {
                commission[i] = cars[i] % 20 * 550 + (cars[i] - 20) * 550;
            }
        }

    }
}
