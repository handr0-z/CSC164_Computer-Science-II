/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JUNE 13, 2025
 PROJECT:       MODULE 5 - LAB 1: CLASS I
 NOTES:         A SIMPLE PROGRAM CREATED TO GET FAMILIAR WITH CLASSES IN JAVA.

 I WROTE ALL THE CODE SUBMITTED, AND I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

public class Main
{
    public static void main(String[] args)
    {
        // Create class of 2 cats
        Cat Tom = new Cat();
        Cat Sylvester = new Cat();
        String newAge = "11";

        // Program Banner
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("                                       ALEJANDRO PANTOJA-ZURITA                                      ");
        System.out.println("                                       MODULE 5 - LAB 1: CLASS I                                     ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("This program is used to test classes within Java. (2) Cat classes are created. Tom & Sylvester.");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Display original age of cats
        System.out.println("Tom's Age: " + Tom.getAge());
        System.out.println("Sylvester's Age: " + Sylvester.getAge());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Test out the sameAge method with same ages.
        System.out.println("Tom and Sylvester are the same age: " + Tom.sameAge(Sylvester));
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Test out birthday() method and setAge() method.
        System.out.println("Increasing Tom & Sylvester's age...\n");
        Tom.birthday();
        Sylvester.setAge(10);

        // Display new age.
        System.out.println("Tom's Age: " + Tom.getAge());
        System.out.println("Sylvester's Age: " + Sylvester.getAge());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Test out the setAge(String) method
        System.out.println("Increasing Tom's age...\n");
        Tom.setAge(newAge);
        System.out.println("Tom's Age: " + Tom.getAge());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Test out the isOld() method;
        System.out.println("Tom is old: " + Tom.isOld());
        System.out.println("Tom's Age: " + Tom.getAge());

        System.out.println("\nSylvester is old: " + Sylvester.isOld());
        System.out.println("Sylvester's Age: " + Sylvester.getAge());
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // Test out the sameAge method.
        System.out.println("Tom and Sylvester are the same age: " + Tom.sameAge(Sylvester) + "\n");
        System.out.println("Increasing Sylvester's age...\n");
        Sylvester.setAge(11);
        System.out.println("Tom's Age: " + Tom.getAge());
        System.out.println("Sylvester's Age: " + Sylvester.getAge());
        System.out.println("\nTom and Sylvester are the same age: " + Tom.sameAge(Sylvester));
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }


}

class Cat
{
    private int age;

    // Method to obtain age of cat. as required.
    public int getAge()
    {
        return age;
    }

    // Method to set age of cat as required from an integer variable.
    public void setAge(int newAge)
    {
        age = newAge;
    }

    // Method to set age of cat as required from a string variable.
    public void setAge(String newAge)
    {
        age = Integer.parseInt(newAge);
    }

    // Method used to determine if cat is older than 10 years old.
    public boolean isOld()
    {
        if (age > 10)
            return true;
        else
            return false;
    }

    // Method used to determine if cat is the same age as another cat.
    public boolean sameAge(Cat anotheCat)
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
