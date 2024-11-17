/**
 * Represents a node in a set based on linked list that stores data
 * Each node contains a reference to the data and a reference to the next node
 */

public class Node {
    private Equipment data;
    private Node next;

    /**
     * Constructor for Node - initializes the node
     * @param data data that stores in the node
     */
    public Node(Equipment data) {
      this.data = data;
      this.next = null;
    }

    /**
     * Returns the data stored in node
     * @return data - the data of Equipment in the node
     */
    public Equipment getData() {
        return data;
    }

    /**
     * Sets the data for the node
     * @param data data to set into the node
     */
    public void setData(Equipment data) {
        this.data = data;
    }

    /**
     * Returns the next node in the set
     * @return next - next node in node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node in the set
     * @param next next node to set in node
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
