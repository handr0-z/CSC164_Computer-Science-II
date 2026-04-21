public class Bird extends Animal
{
    private int altitude;
    private static int birdCount = 0;
    private int birdID = 0;

    // Constructors
    Bird()
    {
        birdCount++;
        birdID = birdCount;
    }
    Bird(int altitude)
    {

        this.altitude = altitude;
        birdCount++;
        birdID = birdCount;
    }
    Bird(int age, int altitude)
    {
        super(age);
        this.altitude = altitude;
        birdCount++;
        birdID = birdCount;
    }

    // Method to set altitude of bird
    void setAltitude(int altitude) {this.altitude = altitude;}

    // Method to get altitude of bird
    int getAltitude() {return this.altitude;}

    // Method to get bird ID.
    int getBirdID(){return birdID;}

    // Method to have bird chirp
    String speak(){return "Tweet tweet";}

}
