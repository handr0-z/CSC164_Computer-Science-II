/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JUNE 28, 2025
 PROJECT:       MODULE 7 - ASSIGNMENT 1: RESTAURANT MENU
 NOTES:         CLASSES & OBJECTS - PROGRAM CREATED TO HELP UNDERSTAND INHERITANCE AND POLYMORPHISM.

 ASIDE FROM THE STARTER CODE PROVIDED FOR THIS ASSIGNMENT, I WROTE ALL THE CODE SUBMITTED.
 OTHERWISE, I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Create Menu for Restaurant.
        ArrayList<RestaurantItem> menu = new ArrayList<>();
        createMenu(menu);

        // Declare any variables needed for program.
        String customerName = " ";
        String menuSelect = " ";
        int[] customerOrder = new int[10];
        int orderQty = 0;
        int i;
        double orderTotal = 0;
        boolean proceed = false;
        boolean loopProgram = false;

        do {
            // Display Program Banner
            programBanner();

            // Prompt user to provide name of customer.
            customerName = obtainName(customerName);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Display restaurant menu to user.
            displayMenu(menu);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Prompt user to order an item from the menu.
            orderQty = placeOrder(orderQty, customerOrder, menu);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Calculate order total
            orderTotal = calculateTotal(orderQty, orderTotal, customerOrder,menu);

            // Display order information for user.
            orderTotal(customerName, orderQty, customerOrder, orderTotal, menu);
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Ask if user would like to order again.
            loopProgram = confirmLoop(menuSelect, loopProgram);

            // Reset any variables needed for new order.
            orderQty = 0;
            orderTotal = 0;

        }while (loopProgram == true);

    }
    // Method used to create restaurant menu.
    static void createMenu(ArrayList<RestaurantItem> menu)
    {
        menu.add(new Food("Cheeseburger", 7.99, "Gluten, Dairy"));
        menu.add(new Food("French Fries", 4.79, "Gluten, Dairy"));
        menu.add(new Food("Salad", 6.49, "Nuts"));
        menu.add(new Food("Pizza", 14.99, "Gluten, Dairy"));
        menu.add(new Food("Cheesesteak", 12.99, "Gluten, Dairy"));
        menu.add(new Drink("Soda", 0.99, "Small"));
        menu.add(new Drink("Soda", 1.49, "Medium"));
        menu.add(new Drink("Soda", 1.99, "Large"));
        menu.add(new Drink("Juice", 0.99, "Small"));
        menu.add(new Drink("Juice", 1.29, "Medium"));
        menu.add(new Drink("Juice", 1.49, "Large"));
        menu.add(new GiftCard("Gift Card", 25.00));
    }

    // Method used to display program banner;
    static void programBanner()
    {
        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                              MODULE 7 - ASSIGNMENT 1:  RESTAURANT MENU                              ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program can be used to place an order from Java Bites Restaurant.");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("WELCOME TO JAVA BITES RESTAURANT!");
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    // Method used to obtain name of customer.
    static String obtainName(String customerName)
    {
        // Prompt user to provide name of customer
        System.out.print("Customer Name: ");
        customerName = input.next();

        return customerName;
    }

    // Method used to display restaurant menu.
    static void displayMenu(ArrayList<RestaurantItem> menu)
    {
        int i =0;

        // Check ArrayList to verify what type of object current array item is and properly obtain information from ArrayList. (Polymorphism)
        System.out.println("JAVA BITES RESTAURANT MENU:");
        for (i = 0; i < menu.size(); i++)
        {
            if (menu.get(i) instanceof Food)
            {
                Food menuItem = (Food) menu.get(i);
                System.out.println((i + 1) + ") " + menuItem.getName());
                System.out.println("\t$" + menuItem.getPrice());
            }
            else if (menu.get(i) instanceof Drink)
            {
                Drink menuItem = (Drink) menu.get(i);
                System.out.println((i + 1) + ") " + menuItem.getName() + " (" +  menuItem.getSize() + ")");
                System.out.println("\t$" + menuItem.getPrice());
            }
            else
            {
                GiftCard menuItem = (GiftCard) menu.get(i);
                System.out.println((i + 1) + ") " + menuItem.getName());
                System.out.printf("\t$ %.2f \n", (menuItem.getPrice()));
                // Formated price to display to decimal places using information obtained from website noted below.
                // https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Format-double-Java-printf-example#:~:text=You%20can%20easily%20achieve%20this,double%20to%20two%20decimal%20places.
            }
        }
    }

    // Method used to obtain order information
    static int placeOrder(int orderQty, int[] customerOrder, ArrayList<RestaurantItem> menu)
    {
        int menuOption = 0;

        System.out.println("Select item from Menu to add to your order (Enter [0] to finish ordering)");

        for (int i =0; i < 10; i++)
        {
            // Trap to ensure valid Menu Option is selected.
            do
            {
                System.out.print("Item #" + (i+1) + ": ");

                // Trap to ensure valid input is used.
                while(true)
                {
                    if (input.hasNextInt()) {break;}
                    else
                    {
                        System.out.println("Error! Invalid INPUT detected.");
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.print("Item #" + (i+1) + ": ");
                        input.next();
                    }
                }
                menuOption = input.nextInt();
                if (menuOption < 0 || menuOption > menu.size())
                {
                    System.out.println("Error! Invalid MENU OPTION selected.");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                }
            } while (menuOption < 0 || menuOption > menu.size());

            if (menuOption == 0)
            {
                System.out.println("Finished Ordering");
                break;
            }
            else
            {
                customerOrder[i] = menuOption -1;
                orderQty++;
            }
        }
        return orderQty;
    }

    // Method used to calculate order total.
    static double calculateTotal(int orderQty, double orderTotal, int[] customerOrder, ArrayList<RestaurantItem> menu)
    {
        int i;

        for (i = 0; i < orderQty; i++)
        {
            // Check which item the customer ordered from the menu.
            if (menu.get(customerOrder[i]) instanceof Food)
            {
                Food menuItem = (Food) menu.get(customerOrder[i]);
                orderTotal += menuItem.getPrice();
            }
            else if (menu.get(customerOrder[i]) instanceof Drink)
            {
                Drink menuItem = (Drink) menu.get(customerOrder[i]);
                orderTotal += menuItem.getPrice();
            }
            else
            {
                GiftCard menuItem = (GiftCard) menu.get(customerOrder[i]);
                orderTotal += menuItem.getPrice();
            }
        }
        return orderTotal;
    }

    // Method used to display order receipt.
    static void orderTotal(String customerName, int orderQty, int[] customerOrder, double orderTotal, ArrayList<RestaurantItem> menu)
    {
        int i = 0;

        System.out.println("\nORDER PLACED!\n");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("CUSTOMER NAME: " + customerName);
        System.out.println("TOTAL ITEMS ORDERED: " + orderQty + "\n");
        for (i = 0; i < orderQty; i++)
        {
            // Check which item the customer ordered from the menu.
            if (menu.get(customerOrder[i]) instanceof Food)
            {
                Food menuItem = (Food) menu.get(customerOrder[i]);
                System.out.println((i+1) + ") " + menuItem.getName());
                System.out.println("* Contains: " + menuItem.getAllergens());
                System.out.println("\t\t\t\t\t\t\t\t\t$" + menuItem.getPrice());
            }
            else if (menu.get(customerOrder[i]) instanceof Drink)
            {
                Drink menuItem = (Drink) menu.get(customerOrder[i]);
                System.out.println((i+1) + ") " +menuItem.getName() + " (" +  menuItem.getSize() + ")");
                System.out.println("\t\t\t\t\t\t\t\t\t$" + menuItem.getPrice());
            }
            else
            {
                GiftCard menuItem = (GiftCard) menu.get(customerOrder[i]);
                System.out.println((i+1) + ") " +menuItem.getName());
                System.out.println("Message: " + menuItem.getMessage());
                System.out.printf("\t\t\t\t\t\t\t\t\t$%.2f \n", (menuItem.getPrice()));
            }
        }
        System.out.printf("\nORDER TOTAL:\t\t\t\t\t\t$ %.2f \n", orderTotal);
    }

    // Method used to confirm if user would like to order again.
    static boolean confirmLoop(String menuSelect, boolean loopProgram)
    {
        boolean proceed = false;
        do {
            System.out.print("Would you like to order again? (Yes/ No) ");
            menuSelect = input.next();

            if (menuSelect.equals("Yes"))
            {
                return true;
            }
            else if (menuSelect.equals("No"))
            {
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("Thank you for dining with us!");
                return false;
            }
            else
            {
                System.out.println("Error! Invalid input detected.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
        } while (proceed == false);

        return loopProgram;
    }
}