/**
 * A class represents a single punctuation symbol
 */

public class Punctuation {
    private final char symbol;

    // Constructor of the class Punctuation
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    // Overriding function for representation Punctuation to String
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
