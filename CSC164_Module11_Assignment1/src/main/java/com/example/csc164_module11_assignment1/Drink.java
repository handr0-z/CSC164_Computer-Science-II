package com.example.csc164_module11_assignment1;

import java.util.Scanner;

class Drink extends RestaurantItem
{
    Scanner input = new Scanner(System.in);

    // Declare any variables needed for class
    private String size; // Small, Medium, Large
    boolean hasIce; // Whether the drink has ice or not

    // Constructor to initialize object with default items.
    Drink()
    {
        super();
        this.size = "Small";
        this.hasIce = true;
    }

    // Constructor to initialize object with specific information.
    Drink(String name, double price, String size)
    {
        super.setName(name);
        super.setPrice(price);
        this.setSize(size);
        this.hasIce = true;
    }

    // Method used to obtain name of drink.
    String getName() {return super.getName();}

    // Method used to obtain price of drink.
    double getPrice() {return super.getPrice();}

    // Method used to obtain size of drink.
    String getSize() {return this.size;}

    // Method used to check if drink has Ice.
    boolean getHasIce(){return this.hasIce;}

    // Method used to set name of drink.
    void setName(String name) {super.setName(name);}

    // Method used to set price of drink.
    void setPrice(double price) {super.setPrice(price);}

    // method used to set allergens of object.
    void setSize(String size)
    {
        // Verify information provided is acceptable
        do
        {
            if (size.equals("Small") || size.equals("Medium") || size.equals("Large"))
            {
                this.size = size;
                break;
            }
            else
            {
                System.out.println("Error! Invalid size detected. Drink must be Small, Medium, or Large.");
                System.out.print("Enter size of drink: ");
                size = input.next();
            }
        } while (true);
    }

    // Method used to add ice to drink.
    void setHasIce(boolean hasIce) {this.hasIce = hasIce;}

    // Method to display information about object
    public String toString(){return "Drink[name: " + super.getName() + ", price $" + super.getPrice() + ", size: " + this.size +", has ice: " + this.hasIce + "]";}

    // Method to display menu info
    public String menuDisplay(){return super.getName() + " --- Price: $" + super.getPrice() + " --- Size: " + this.size + " --- Has Ice: " + this.hasIce;}

    // Method to insert information to file.
    public String toFile(){return "Drink," + super.getName() + "," + super.getPrice() + "," + this.size + "," + this.hasIce;}
}