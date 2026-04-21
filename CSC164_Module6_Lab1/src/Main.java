/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JUNE 21, 2025
 PROJECT:       MODULE 6 - LAB 1: CLASS III
 NOTES:         A SIMPLE PROGRAM CREATED TO GET FAMILIAR WITH CLASSES IN JAVA.

 I WROTE ALL THE CODE SUBMITTED, AND I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Initialize objects
        Cat cat1 = new Cat("Sylvester", 12);
        Cat cat2 = new Cat("Tom", 5);
        Bird bird1 = new Bird(11, 250);
        Bird bird2 = new Bird(7, 430);

        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                      MODULE 6 - LAB 1: CLASS III                                     ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program is used to test classes within Java and understand inheritance.");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Display animal information to user.
        System.out.println("ANIMAL INFORMATION");
        System.out.println("Animal Type: CAT");
        System.out.println("Name: " + cat1.getName());
        System.out.println("Age: " + cat1.getAge());
        System.out.println("\nAnimal Type: CAT");
        System.out.println("Name: " + cat2.getName());
        System.out.println("Age: " + cat2.getAge());
        System.out.println("\nAnimal Type: BIRD");
        System.out.println("Bird #" + bird1.getBirdID() + " age: " + bird1.getAge());
        System.out.println("Altitude: " + bird1.getAltitude() +" ft");
        System.out.println("\nAnimal Type: BIRD");
        System.out.println("Bird #" + bird2.getBirdID() + " age: " + bird2.getAge());
        System.out.println("Altitude: " + bird2.getAltitude()+ " ft");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Display speak methods for each animal
        System.out.println("SPEAK COMMAND");
        System.out.println(cat1.getName() +": " + cat1.speak());
        System.out.println(cat2.getName() +": " + cat2.speak());
        System.out.println("Bird #" + bird1.getBirdID() + ": " + bird1.speak());
        System.out.println("Bird #" + bird2.getBirdID() + ": " + bird2.speak());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Check if animals are considered old.
        System.out.println("CHECK IF ANIMALS ARE CONSIDERED OLD (OVER 10 YEARS)");
        System.out.println(cat1.getName() + " is old? "+ cat1.isOld());
        System.out.println(cat2.getName() + " is old? "+ cat2.isOld());
        System.out.println("Bird #" + bird1.getBirdID() + " is old? "+ bird1.isOld());
        System.out.println("Bird #" + bird2.getBirdID() + " is old? "+ bird2.isOld());
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}