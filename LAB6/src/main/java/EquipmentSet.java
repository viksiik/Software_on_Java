import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A class that represents a set of Equipment elements
 */

public class EquipmentSet implements Set<Equipment> {

    private Node head;
    private int size;

    /**
     * Default constructor - initializes an empty set
     */
    public EquipmentSet() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructor that accepts a single Equipment object
     * @param equipment the equipment to add
     */
    public EquipmentSet(Equipment equipment) {
        this();
        add(equipment);
    }

    /**
     * Constructor that accepts a collection of Equipment objects
     * @param equipments the collection of equipment to add
     */
    public EquipmentSet(Collection<? extends Equipment> equipments) {
        this();
        addAll(equipments);
    }

    /**
     * Returns the number of elements in the set
     * @return size - the number of elements in the set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the set is empty
     * @return true - if the set has no elements
     *         false - if the set has elements
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks if the specified element of Equipment is present in the set.
     *
     * @param object the element to check for presence in the set
     * @return true if the element is present in the set
     *         false if the element is not present in the set
     */
    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Equipment)) {
            return false;
        }

        Node current = head;
        while (current != null) {
            if (current.getData().equals(object)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in the set
     * @return Iterator<> - an iterator over the elements in the set
     * @throws NoSuchElementException if the element has not have next node
     */
    @Override
    public Iterator<Equipment> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Equipment next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Equipment data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    /**
     * Returns an array containing all the elements in the set
     * @return array - an array containing all the elements in the set
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node current = head;
        while (current != null) {
            array[index++] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    /**
     * Returns an array containing all the elements in the set in proper sequence (from first to last element)
     *
     * @param <T> the runtime type of the array elements
     * @param a the array into which the elements of the set are to be stored
     * @return a - an array containing all the elements in the set
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        Node current = head;
        while (current != null) {
            a[index++] = (T) current.getData();
            current = current.getNext();
        }
        return a;
    }

    /**
     * Adds the specified element to the set
     * @param equipment the element to add to the set
     * @return true - if the element was added successfully
     *         false - if the element was not added or was already in the set
     */
    @Override
    public boolean add(Equipment equipment) {
        if (equipment == null || contains(equipment)) {
            return false;
        }

        Node newNode = new Node(equipment);
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        if(find(equipment)){
            return false;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        size++;

        return true;
    }

    /**
     * Removes the specified element from the set
     * @param object the element to remove from the set
     * @return true - if the element was removed successfully
     *         false - if the element was not removed
     */
    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Equipment)) {
            return false;
        }

        if (this.isEmpty()) {
            return false;
        }

        Node currentNode = head;
        Node previous = null;

        if(head.getData().equals(object)){
            head = head.getNext();
            size--;
            return true;
        }

        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                previous.setNext(currentNode.getNext());
                size--;
                return true;
            }

            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * Checks if the set contains all elements in the specified collection
     *
     * @param collection the collection of elements to check for presence in the set
     * @return true - if the set contains all elements in the collection
     *         false - if the set does not contain all elements in the collection
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("The specified collection is null.");
        }

        for (Object object : collection) {
            if (!contains(object)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements in the specified collection to the set
     * @param collection collection containing elements to be added to this collection
     * @return true - if at least one element was added to the set
     *         false - if no elements was not added to the set
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends Equipment> collection) {
        if (collection == null) {
            throw new NullPointerException("The specified collection is null.");
        }

        boolean modified = false;
        for (Equipment equipment : collection) {
            if (add(equipment)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in the set that are contained in the specified collection
     * @param collection collection containing elements to be retained in this set
     * @return true - if the set modified as a result of retain
     *         false - if the set was not retained
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("The specified collection is null.");
        }

        boolean modified = false;
        Node currentNode = head;
        Node previous = null;

        while (currentNode != null) {
            if (!collection.contains(currentNode.getData())) {
                previous.setNext(currentNode.getNext());
                size--;
                modified = true;
            } else {
                previous = currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return modified;
    }

    /**
     * Removes all elements in the specified collection from the set
     * @param collection collection containing elements to be removed from this set
     * @return true - if at least one element was removed
     *         false - if no elements was removed
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("The specified collection is null.");
        }

        boolean modified = false;
        for (Object object : collection) {
            if (remove(object)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements from the set.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Finds the specified element in the set
     * @param equipment the element to find in the set
     * @return true - if the element was found successfully
     *         false - if the element was not found
     */
    public boolean find(Equipment equipment) {
        if(equipment == null){
            return false;
        }
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(equipment)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }
}
