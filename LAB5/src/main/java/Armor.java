/**
 * A class that represents an armor and extends the abstract class Equipment
 */

public class Armor extends Equipment{

    /**
     * Constructor of the Armor class to initialize the basic characteristics of the armor
     *
     * @param name   The name of the armor
     * @param price  The price of the armor
     * @param weight The weight of the armor
     */
    public Armor(String name, double price, double weight) {
        super(name, price, weight);
    }

    // Overriding method from the Equipment class
    @Override
    public void displayInfo() {
        System.out.println("Armor: " + name + ", Price: " + price + ", Weight: " + weight);

    }
}
