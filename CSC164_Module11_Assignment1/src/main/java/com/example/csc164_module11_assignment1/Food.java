package com.example.csc164_module11_assignment1;

import java.util.Scanner;

class Food extends RestaurantItem
{
    Scanner input = new Scanner(System.in);

    // Declare any variables needed for class.
    private String allergens;

    // Constructors
    Food()
    {
        super();
        this.allergens = "No Allergens";
    }
    Food(String name, double price)
    {
        super.setName(name);
        super.setPrice(price);
        this.allergens ="No Allergens";
    }
    Food(String name, double price, String allergens)
    {
        super.setName(name);
        super.setPrice(price);

        if (allergens.isEmpty())
            this.allergens = "N/A";
        else
            this.allergens = allergens;
    }
    Food(String name, double price, String allergen1, String allergen2)
    {
        super.setName(name);
        super.setPrice(price);

        if (allergen1.isEmpty())
            this.allergens = "N/A";
        else {
            if (allergen2.isEmpty())
                this.allergens = allergen1;
            else
                this.allergens = allergen1 + "," + allergen2;
        }

        if (allergen1.isEmpty())
            this.allergens = "N/A";
        else
            this.allergens = allergens;
    }

    // Method used to obtain name of food.
    String getName() {return super.getName();}

    // Method used to obtain price of food.
    double getPrice() {return super.getPrice();}

    // Method used to obtain allergens of food.
    String getAllergens() {return this.allergens;}

    // Method used to set name of food.
    void setName(String name) {super.setName(name);}

    // Method used to set price of food.
    void setPrice(double price) {super.setPrice(price);}

    // method used to set allergens of food.
    void setAllergens(String allergens)
    {
        if (allergens.isEmpty())
            allergens = "N/A";
        else
            allergens = allergens;
    }

    // Method to display information about food.
    public String toString(){return "Food[name: " + super.getName() + ", price $" + super.getPrice() + ", allergens: " + this.allergens + "]";}

    // Method to display menu info
    public String menuDisplay(){return super.getName() + " --- Price: $" + super.getPrice() + " --- Allergens: " + this.allergens;}

    // Method to insert information to file.
    public String toFile(){return "Food," + super.getName() + "," + super.getPrice() + "," + this.allergens;}
}