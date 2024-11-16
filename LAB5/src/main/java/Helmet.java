/**
 * A class that represents a helmet and extends the abstract class Equipment
 */

public class Helmet extends Equipment{

    /**
     * Constructor of the Helmet class to initialize the basic characteristics of the helmet

     * @param name   The name of the helmet
     * @param price  The price of the helmet
     * @param weight The weight of the helmet
     */
    public Helmet(String name, double price, double weight) {
        super(name, price, weight);
    }

    // Overriding method from the Equipment class
    @Override
    public void displayInfo() {
        System.out.println("Helmet: " + name + ", Price: " + price + ", Weight: " + weight);
    }
}
