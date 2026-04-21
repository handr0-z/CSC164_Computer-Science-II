package com.example.csc164_module11_assignment1;

import java.util.Scanner;

public abstract class RestaurantItem
{
    Scanner input = new Scanner(System.in);

    private String name;
    private double price;

    // Constructors
    RestaurantItem()
    {
        this.name = "Default";
        this.price = 0.00;
    }
    RestaurantItem(String name, double price)
    {
        do
        {
            if (name.isEmpty())
            {
                System.out.println("Error! Invalid input detected. Menu item must have a name.");
                System.out.print("Enter name of menu item: ");
                name = input.next();
            }
            else
                this.name = name;
        } while (name.isEmpty());

        do
        {
            if (price <= 0)
            {
                System.out.println("Error! Invalid input detected. Price of item must be above $0.00.");
                System.out.print("Enter price of menu item: ");
                price = input.nextDouble();
            }
            else
                this.price = price;
        } while (price <= 0);
    }

    // Method used to obtain name of object
    String getName() {return this.name;}

    // Method used to obtain price of object
    double getPrice() {return this.price;}

    // Method used to set name of object.
    void setName(String name)
    {
        // Verify information provided is acceptable
        do
        {
            if (name.isEmpty())
            {
                System.out.println("Error! Invalid input detected. Menu item must have a name.");
                System.out.print("Enter name of menu item: ");
                name = input.next();
            }
            else
                this.name = name;
        } while (name.isEmpty());
    }

    // Method used to set price of object.
    void setPrice(double price)
    {
        do
        {
            if (price <= 0)
            {
                System.out.println("Error! Invalid input detected. Price of item must be above $0.00.");
                System.out.print("Enter price of menu item: ");
                price = input.nextDouble();
            }
            else
                this.price = price;
        } while (price <= 0);
    }

    // Method to display information about object
    public abstract String toString();

    // Method to display information about object
    public abstract String menuDisplay();

    public abstract String toFile();
}
