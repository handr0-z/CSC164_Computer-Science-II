/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JUNE 14, 2025
 PROJECT:       MODULE 5 - ASSIGNMENT 1: RESTAURANT MENU
 NOTES:         CLASSES & OBJECTS - PROGRAM CREATED TO HELP UNDERSTAND OBJECTS IN JAVA.

 ASIDE FROM THE STARTER CODE PROVIDED FOR THIS ASSIGNMENT, I WROTE ALL THE CODE SUBMITTED.
 OTHERWIS I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Declare any classes needed for program.
        Food[] menu =
                {
                new Food("Burger", 5.99, "Gluten, Dairy"),
                new Food("Salad", 4.49, "Nuts"),
                new Food("Pizza", 8.99, "Gluten, Dairy"),
                new Food("Soup", 3.99, "None"),
                new Food("Pasta", 7.49, "Gluten, Dairy")
                };

        // Declare any variables needed for program.
        String customerName = " ";
        String menuSelect;
        int[] customerOrder = new int[2];
        int orderQty = 0;
        int i;
        double orderTotal = 0;
        boolean proceed = false;
        boolean loopProgram = false;

        do {
            // Display Program Banner
            programBanner();

            // Display Welcome message.
            System.out.println("WELCOME TO JAVA BITES RESTAURANT!");
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Prompt user to provide name of customer.
            customerName = obtainName(customerName);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Display restaurant menu to user.
            displayMenu(menu);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Prompt user to order an item from the menu.
            orderQty = menuSelect(orderQty, customerOrder, menu);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Ask if user would like to order a second item.
            do
            {
                System.out.print("Order second item? (Yes/ No) ");
                menuSelect = input.next();

                if (menuSelect.equals("Yes"))
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    orderQty = menuSelect(orderQty, customerOrder, menu);
                    proceed = true;
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                } else if (menuSelect.equals("No")) {
                    proceed = true;
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("\nError! Invalid input detected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    proceed = false;
                }
            } while (proceed == false);

            // Calculate order total
            for (i = 0; i < orderQty; i++)
            {
                orderTotal += (menu[customerOrder[i]].getPrice());
            }

            // Display order information for user.
            System.out.println("\nORDER PLACED!\n");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            orderTotal(customerName, orderQty, customerOrder, orderTotal, menu);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Ask if user would like to order again.
            do {
                System.out.print("Would you like to run program again? (Yes/ No) ");
                menuSelect = input.next();

                if (menuSelect.equals("Yes"))
                {
                    loopProgram = true;
                    proceed = true;
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                }
                else if (menuSelect.equals("No"))
                {
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("Thank you for dining with us!");
                    loopProgram = false;
                    proceed = true;
                } else
                {
                    System.out.println("\nError! Invalid input detected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    proceed = false;
                }
            } while (proceed == false);

            // Reset any variables needed for new order.
            orderQty = 0;
            orderTotal = 0;

        }while (loopProgram == true);

    }

    // Method used to display program banner;
    public static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                              MODULE 5 - ASSIGNMENT 1:  RESTAURANT MENU                              ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used to place an order from Java Bites Restaurant (2 items max per customer)");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to obtain name of customer.
    public static String obtainName(String customerName)
    {
        // Prompt user to provide name of customer
        System.out.print("Enter Name of Customer: ");
        customerName = input.next();

        return customerName;
    }

    // Method used to display restaurant menu.
    public static void displayMenu(Food[] menu)
    {
        int i =0;

        System.out.println("JAVA BITES RESTAURANT MENU:");
        for (i = 0; i < menu.length; i++) {
            System.out.println(((i + 1) + ") " + menu[i].getName() + " ($" + menu[i].getPrice()) + ")");
            System.out.println("\tContains: " + menu[i].getAllergens());
        }
    }

    // Method used to obtain order information
    public static int menuSelect(int orderQty, int[] customerOrder, Food[] menu)
    {
        int menuOption = 0;

        do {
            System.out.println("What item would you like to order?");
            System.out.print("Enter an item number (1-5) to add item to order: ");

            // Trap to ensure valid input is used.
            while(true)
            {
                if (input.hasNextInt())
                {
                    menuOption = input.nextInt();
                    break;
                }
                else
                {
                    System.out.println("\nError! Invalid input detected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("What item would you like to order?");
                    System.out.print("Enter an item number (1-5) to add item to order: ");
                    input.next();
                }
            }

            switch (menuOption) {
                case 1:
                    customerOrder[0] = 0;
                    orderQty++;
                    break;
                case 2:
                    customerOrder[0] = 1;
                    orderQty++;
                    break;
                case 3:
                    customerOrder[0] = 2;
                    orderQty++;
                    break;
                case 4:
                    customerOrder[0] = 3;
                    orderQty++;
                    break;
                case 5:
                    customerOrder[0] = 4;
                    orderQty++;
                    break;
                default:
                    System.out.println("\nError! Invalid input detected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
            }

        } while (menuOption <= 0 || menuOption > menu.length);

        return orderQty;
    }

    // Method used to display order receipt.
    public static void orderTotal(String customerName, int orderQty, int[] customerOrder, double orderTotal, Food[] menu)
    {
        int i = 0;

        System.out.println("CUSTOMER NAME: " + customerName);
        System.out.println("TOTAL ITEMS ORDERED: #" + orderQty + "\n");
        for (i = 0; i < orderQty; i++) {
            System.out.println("ITEM " + (i + 1));
            System.out.println(menu[customerOrder[i]].getName() + "\t\t\t\t\t\t$" + menu[customerOrder[i]].getPrice());
            System.out.println("* Contains: " + menu[customerOrder[i]].getAllergens() + "\n");
        }
        System.out.println("ORDER TOTAL:\t\t\t\t$" + orderTotal);
    }
}
