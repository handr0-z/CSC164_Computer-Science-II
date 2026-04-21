class Cat extends Animal
{
    private String name;

    // Constructors
    Cat() {}
    Cat(String name) {this.name = name;}
    Cat(String name, int age)
    {
        super(age);
        this.name = name;
    }

    // Method to set name of cat.
    void setName(String name) {this.name = name;}

    // Method to get name of cat.
    String getName() {return this.name;}

    // Method to have cat speak.
    String speak(){return "Meow";}
}