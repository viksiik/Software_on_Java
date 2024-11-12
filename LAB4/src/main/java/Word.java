/**
 * A class represents a word composed of multiple Letter objects
 */

public class Word {
    private final Letter[] letters;

    // Constructor of the class Word
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    // Overriding function for representation Word to String
    @Override
    public String toString() {
        String result = "";
        for (Letter letter : letters) {
            result += letter;
        }
        return result;
    }

}
