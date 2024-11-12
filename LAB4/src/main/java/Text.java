import java.util.HashSet;
import java.util.Set;

/**
 * A class represents a text, composed of sentences, words and punctuation elements
 */

public class Text {
    private final Sentence[] sentences;

    // Constructor of the class Text
    public Text(String text) {
        String[] sentenceParts = text.split("(?<=\\.)\\s*");
        sentences = new Sentence[sentenceParts.length];
        for (int i = 0; i < sentenceParts.length; i++) {
            sentences[i] = new Sentence(sentenceParts[i]);
        }
    }

    /**
     * Finds words that only appear in the first sentence and not in any other sentence
     *
     * @return an array of unique words in the first sentence
     */
    public Word[] findUniqueWords() {
        if (sentences.length == 0) {
            throw new IllegalArgumentException("Text must contain at least one sentence.");
        }

        Word[] firstSentenceWords = sentences[0].getWords();
        Set<String> otherSentenceWords = new HashSet<>();

        for (int i = 1; i < sentences.length; i++) {
            Word[] wordsInSentence = sentences[i].getWords();
            for (Word word : wordsInSentence) {
                otherSentenceWords.add(word.toString().toLowerCase());
            }
        }

        Word[] tempUniqueWords = new Word[firstSentenceWords.length];
        int uniqueCount = 0;

        for (Word word : firstSentenceWords) {
            if (!otherSentenceWords.contains(word.toString().toLowerCase())) {
                tempUniqueWords[uniqueCount++] = word;
            }
        }

        // Create the exact-sized array to return
        Word[] uniqueWords = new Word[uniqueCount];
        System.arraycopy(tempUniqueWords, 0, uniqueWords, 0, uniqueCount);

        return uniqueWords;
    }

    // Overriding function for representation Text to String
    public String toString() {
        String result = "";
        for (Sentence sentence : sentences) {
            result += sentence + " ";
        }
        return result.trim();
    }

}
