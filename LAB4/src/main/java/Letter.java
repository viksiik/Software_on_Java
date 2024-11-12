/**
 * A class represents a single character in a word
 */

public class Letter {
    private final char character;

    // Constructor of the class Letter
    public Letter(char character) {
        this.character = character;
    }

    // Overriding function for representation Letter to String
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
