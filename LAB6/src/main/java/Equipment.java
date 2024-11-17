/**
 * An abstract class that represents a general template for various types of equipment
 */

abstract class Equipment {
    protected String name;
    protected double price;
    protected double weight;

    /**
     * Constructor for the Equipment class to initialize the basic characteristics of the equipment
     *
     * @param name   The name of the equipment
     * @param price  The price of the equipment
     * @param weight The weight of the equipment
     */
    public Equipment(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    /**
     * Abstract method to display information about the equipment
     */
    public abstract void displayInfo();

    /**
     * Returns the name of the equipment
     * @return the name of the equipment
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the equipment
     * @param name the name of the equipment
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the equipment
     * @return the price of the equipment
     */
    public double getPrice() {
        return price;
    }
    /**
     * Sets the price of the equipment
     * @param price the price of the equipment
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the weight of the equipment
     * @return the weight of the equipment
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Sets the weight of the equipment
     * @param weight the weight of the equipment
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
