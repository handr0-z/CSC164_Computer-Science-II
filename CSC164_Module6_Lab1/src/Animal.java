import org.w3c.dom.ls.LSOutput;

public class Animal
{
    private int age;

    // Constructors
    Animal() {}
    Animal(int age) {this.age = age;}

    // Method to set age of animal.
    void setAge(int age) {this.age = age;}

    // Method to get age of animal.
    int getAge() {return this.age;}

    // Method used to determine if animal is older than 10 years old.
    boolean isOld() {return this.age > 10;}

    // Method to increase the age of animal
    void birthday() {this.age++;}

    // Method to have animal make noise
    String speak(){return "This animal is making noises";}
}
