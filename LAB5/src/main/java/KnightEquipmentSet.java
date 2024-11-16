import java.util.Arrays;

/**
 * A class represents a collection of Equipment objects, such as a knight's equipment set.
 */

public class KnightEquipmentSet {
    private final Equipment[] equipments;

    /**
     * Constructor for the KnightEquipmentSet class
     * @param equipments An array of Equipment objects
     */
    public KnightEquipmentSet(Equipment[] equipments) {
        this.equipments = equipments;
    }

    /**
     * Calculates the total cost of all equipment in the set
     *
     * @return The total cost as a double
     */
    public double totalCost() {
        double total = 0;
        for (Equipment equip : equipments) {
            total += equip.getPrice();
        }
        return total;
    }

    // Sorting equipment by the weight
    public void sortByWeight() {
        Arrays.sort(equipments,
                    (e1, e2) -> Double.compare(e1.getWeight(), e2.getWeight()));
    }

    /**
     * Finds and displays equipment items whose price falls within the specified range
     *
     * @param minPrice The minimum price of the range
     * @param maxPrice The maximum price of the range
     */
    public void findItemsInPriceRange(double minPrice, double maxPrice) {
        for (Equipment equip : equipments) {
            if (equip.getPrice() >= minPrice && equip.getPrice() <= maxPrice) {
                equip.displayInfo();
            }
        }
    }

    // Displays information about all the equipment items in the set
    public void displayInfo() {
        for (Equipment equip : equipments) {
            equip.displayInfo();
        }
    }
}
