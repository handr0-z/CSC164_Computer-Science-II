package com.example.csc164_module9_assignment1;

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
        balance = super.getPrice();
        message = "N/A";
    }
    GiftCard(String name, double price)
    {
        super.setName(name);
        super.setPrice(price);
        balance = super.getPrice();
        message = "N/A";
    }

    // Method used to obtain name on gift card
    String getName() {return super.getName();}

    // Method used to obtain price of gift card.
    double getPrice() {return super.getPrice();}

    // Method used to obtain balance of gift card.
    double getBalance() {return balance;}

    // Method used to obtain message on gift card.
    String getMessage() {return message;}

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
    public String toString(){return "Gift Card[name: " + super.getName() + ", price $" + super.getPrice() + ", balance: " + balance + ", message: " + message + "]";}

}