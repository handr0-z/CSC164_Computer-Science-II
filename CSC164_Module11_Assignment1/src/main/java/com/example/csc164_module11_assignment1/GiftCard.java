package com.example.csc164_module11_assignment1;

import java.util.Scanner;

class GiftCard extends RestaurantItem
{
    Scanner input = new Scanner(System.in);

    // Declare any variables needed for class.
    private double balance; // Remaining balance on the gift card.
    private String message; // Custom message on the gift card.

    // Constructors
    GiftCard()
    {
        super();
        this.balance = super.getPrice();
        this.message = "N/A";
    }
    GiftCard(String name, double price)
    {
        super.setName(name);
        super.setPrice(price);
        this.balance = super.getPrice();
        this.message = "N/A";
    }
    GiftCard(String name, double price, double balance, String message)
    {
        super.setName(name);
        super.setPrice(price);
        setBalance(balance);
        setMessage(message);
    }

    // Method used to obtain name on gift card
    String getName() {return super.getName();}

    // Method used to obtain price of gift card.
    double getPrice() {return super.getPrice();}

    // Method used to obtain balance of gift card.
    double getBalance() {return this.balance;}

    // Method used to obtain message on gift card.
    String getMessage() {return this.message;}

    // Method used to set name of gift card.
    void setName(String name) {super.setName(name);}

    // Method used to set price of gift card.
    void setPrice(double price) {super.setPrice(price);}

    // method used to set balance of gift card.
    void setBalance(double balance)
    {
        if (balance >= 0)
            this.balance = balance;
        else
            this.balance = super.getPrice(); // if no balance is provided default price will be the price paid for gift card.
    }

    // Method used to obtain message on gift card.
    void setMessage(String message) {this.message = message;}

    // Method to display information about gift card.
    public String toString(){return "Gift Card[name: " + super.getName() + ", price $" + super.getPrice() + ", balance: " + this.balance + ", message: " + this.message + "]";}

    // Method to display menu info
    public String menuDisplay(){return super.getName() + " --- Price:  $" + super.getPrice() + " --- Balance: $" + this.balance + " --- Message: " + this.message;}

    // Method to insert information to file.
    public String toFile(){return "Food," + super.getName() + "," + super.getPrice() + "," + this.balance + "," + this.message;}
}