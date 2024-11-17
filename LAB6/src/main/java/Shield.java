/**
 * A class that represents a shield and extends the abstract class Equipment
 */

public class Shield extends Equipment{

    /**
     * Constructor of the Shield class to initialize the basic characteristics of the shield
     *
     * @param name   The name of the shield
     * @param price  The price of the shield
     * @param weight The weight of the shield
     */
    public Shield(String name, double price, double weight) {
        super(name, price, weight);
    }

    // Overriding method from the Equipment class
    @Override
    public void displayInfo() {
        System.out.println("Shield: " + name + ", Price: " + price + ", Weight: " + weight);

    }
}
