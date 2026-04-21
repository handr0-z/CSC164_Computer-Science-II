/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JUNE 13, 2025
 PROJECT:       MODULE 5 - LAB 2: CLASS II
 NOTES:         A SIMPLE PROGRAM CREATED TO GET FAMILIAR WITH CLASSES IN JAVA.

 I WROTE ALL THE CODE SUBMITTED, AND I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Create class of 2 cats
        Cat garfield = new Cat();
        Cat crookshanks = new Cat();

        // Create a 3rd Cat class for user input.
        Cat userCat = new Cat();

        // Variables needed to run program.
        String name1 = "Garfield";
        String name2 = "Crookshanks";
        String name3;
        int age;
        Scanner input = new Scanner(System.in);


        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                      MODULE 5 - LAB 2: CLASS II                                     ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program is used to test classes within Java. Garfield and Crookshanks Cat classes created.");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Set name and correct age of both cats.
        garfield.setName(name1);
        garfield.setAge(7);
        crookshanks.setName(name2);
        crookshanks.setAge(11);

        // Display original age of cats
        System.out.println(garfield.getName() + "'s Age: "+ garfield.getAge());
        System.out.println(crookshanks.getName() + "'s Age: "+ crookshanks.getAge());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Check if Garfield is considered old.
        System.out.println(garfield.getName() + " is old (over 10 years old): "+ garfield.isOld());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Check if Garfield and Crookshanks are the same age
        System.out.println(garfield.getName() + " and " + crookshanks.getName() + " are the same age: " + garfield.sameAge(crookshanks));
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Inform user of 3rd Cat.
        System.out.println("New cat adopted!\n");

        // Prompt User to provide name of 3rd Cat.
        System.out.print("Enter name of cat: ");
        name3 = input.next();
        userCat.setName(name3);

        // Prompt User to provide age of 3rd Cat.
        do
        {
            System.out.print("How old is " + userCat.getName() + "? ");
            age = input.nextInt();

            if (age<0)
                System.out.println("\nError! invalid input provided. Age cannot be negative number");

            System.out.println("-----------------------------------------------------------------------------------------------------");
        } while (age < 0);

        userCat.setAge(age);

        // Display information of all cats to user.
        System.out.println(userCat.getName() + "'s Age: "+ userCat.getAge());
        System.out.println(garfield.getName() + "'s Age: "+ garfield.getAge());
        System.out.println(crookshanks.getName() + "'s Age: "+ crookshanks.getAge() + "\n");

        // Determine which cat is older and inform the user.
        if (userCat.getAge() > garfield.getAge() && userCat.getAge() > crookshanks.getAge())
            System.out.println(userCat.getName() + " is the oldest.");
        else if (userCat.getAge() < garfield.getAge() && garfield.getAge() > crookshanks.getAge())
            System.out.println(garfield.getName() + " is the oldest.");
        else if (userCat.getAge() < crookshanks.getAge() && garfield.getAge() < crookshanks.getAge())
            System.out.println(crookshanks.getName() + " is the oldest.");
        else if (userCat.getAge() == garfield.getAge() && userCat.getAge() == crookshanks.getAge())
            System.out.println("All cats are the same age.");
        else if (userCat.getAge() == garfield.getAge() && userCat.getAge() > crookshanks.getAge())
            System.out.println(userCat.getName() + " and " + garfield.getName() + " are the oldest and are the same age.");
        else if (userCat.getAge() < garfield.getAge() && garfield.getAge() == crookshanks.getAge())
            System.out.println(garfield.getName() + " and " + crookshanks.getName() + " are the oldest and are the same age.");
        else
            System.out.println(userCat.getName() + " and " + crookshanks.getName() + " are the oldest and are the same age.");

        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}

class Cat
{
    private int age;
    private String name;

    // no arg constructor to initialize the class
    Cat()
    {
        age = 0;
    }

    // constructor to initialize class with specified age and name.
    Cat(int setAge)
    {
        age = setAge;
    }

    // Method to obtain age of cat as required.
    int getAge()
    {
        return age;
    }

    // Method to obtain name of cat as required.
    String getName()
    {
        return name;
    }

    // Method to set age of cat as required from an integer variable.
    void setAge(int newAge)
    {
        age = newAge;
    }

    // Method to set name of cat.
    void setName(String newName)
    {
        name = newName;
    }

    // Method to set age of cat as required from a string variable.
    void setAge(String newAge)
    {
        age = Integer.parseInt(newAge);
    }

    // Method used to determine if cat is older than 10 years old.
    boolean isOld()
    {
        if (age > 10)
            return true;
        else
            return false;
    }

    // Method used to determine if cat is the same age as another cat.
    boolean sameAge(Cat anotheCat)
    {
        if (this.age == anotheCat.getAge())
            return true;
        else
            return false;
    }

    // Method used to increase the age of the cat.
    void birthday()
    {
        age++;
    }
}