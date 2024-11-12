/**
 * A class represents a sentence, composed of words and punctuation elements
 */

public class Sentence {
    private final Object[] elements;

    // Constructor of the class Sentence
    public Sentence(String sentence) {
        String[] parts = sentence.split("(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)");
        elements = new Object[parts.length];
        int index = 0;

        for (String part : parts) {
            if (part.matches("\\w+")) {
                elements[index++] = new Word(part);
            } else if (part.matches("\\W")) {
                elements[index++] = new Punctuation(part.charAt(0));
            }
        }
    }

    // Overriding function for representation Sentence to String
    @Override
    public String toString() {
        String result = "";
        for (Object element : elements) {
            if (element != null) {
                result += element.toString();
            }
        }
        return result;
    }

    // Retrieve an array of Word objects
    public Word[] getWords() {
        int wordCount = 0;

        // Count the number of words
        for (Object element : elements) {
            if (element instanceof Word) {
                wordCount++;
            }
        }

        Word[] words = new Word[wordCount];
        int index = 0;

        // Populate the words in an array
        for (Object element : elements) {
            if (element instanceof Word) {
                words[index++] = (Word) element;
            }
        }

        return words;
    }
}
