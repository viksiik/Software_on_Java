/**
 * A class that represents a sword and extends the abstract class Equipment
 */

public class Sword extends Equipment{

    /**
     * Constructor of the Sword class to initialize the basic characteristics of the sword
     *
     * @param name   The name of the sword
     * @param price  The price of the sword
     * @param weight The weight of the sword
     */
    public Sword(String name, double price, double weight) {
        super(name, price, weight);
    }

    // Overriding method from the Equipment class
    @Override
    public void displayInfo() {
        System.out.println("Sword: " + name + ", Price: " + price + ", Weight: " + weight);
    }
}
