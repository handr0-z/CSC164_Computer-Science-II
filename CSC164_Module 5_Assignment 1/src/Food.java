import java.util.Scanner;

class Food
{
    Scanner input = new Scanner(System.in);

    // Declare any variables needed for class
    private String foodName;
    private double foodPrice;
    private String foodAllergens;

    // Constructor to initialize object with default items.
    Food()
    {
        foodName = "Default Menu Item";
        foodPrice = 0;
        foodAllergens = "No Allergens";
    }

    // Constructor to initialize object with specific information.
    Food(String name, double price, String allergens)
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
                foodName = name;
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
                foodPrice = price;
        } while (price <= 0);

        if (allergens.isEmpty())
            foodAllergens = "N/A";
        else
            foodAllergens = allergens;
    }

    // Method used to obtain name of object
    String getName()
    {
        return foodName;
    }

    // Method used to obtain price of object
    Double getPrice()
    {
        return foodPrice;
    }

    // Method used to obtain allergens of object
    String getAllergens()
    {
        return foodAllergens;
    }

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
                foodName = name;
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
                foodPrice = price;
        } while (price <= 0);
    }

    // method used to set allergens of object.
    void setAllergens(String allergens)
    {
        if (allergens.isEmpty())
            foodAllergens = "N/A";
        else
            foodAllergens = allergens;
    }

}