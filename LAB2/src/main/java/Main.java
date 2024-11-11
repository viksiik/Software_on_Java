/*
* Визначити C3 як остачу від ділення номера залікової книжки студента на 3,
*  C17 як остачу від ділення номера залікової книжки студента на 17.

* В залежності від C3 визначити тип текстових змінних:
* С3 = 1
* Тип:
* String

* В залежності від C17 визначити дію з текстом:
* C17 = 2
* Дія з текстом:
* Знайти таке слово в першому реченні заданого тексту, якого немає в жодному з наступних.

*  Створити клас, який складається з виконавчого методу,
*  що виконує дію з текстовим рядком (п.3) використовуючи для цього
*  тип даних згідно варіанту (п.3). Необхідно обробити всі виключні ситуації,
*  що можуть виникнути під час виконання програмного коду.
*  Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
*  Код повинен відповідати стандартам Java Code Conventions (або Google Java Style Guide)
*  та бути завантаженим на GitHub.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean choice;

        try {
            do {
                System.out.println("Enter text (minimum 1 sentence):");
                String inputText = scanner.nextLine();

                List<String> uniqueWord = findUniqueWords(inputText);

                if (!uniqueWord.isEmpty()) {
                    System.out.println("Words that doesn`t repeat in sentences: " + uniqueWord);
                } else {
                    System.out.println("Unique word is not found.");
                }
                choice = doChoice();
            } while (choice);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } 
    }

    private static boolean doChoice() {
        char choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to run the program again? (y/n)");
        while (true) {
            try {
                choice = scanner.next().toLowerCase().charAt(0);
                if (choice == 'y') {
                    return true;
                } else if (choice == 'n') {
                    return false;
                } else {
                    System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                scanner.next();
            }
        }
    }

    private static List<String> findUniqueWords(String text) {
        String[] sentences = text.split("\\.\\s*");

        if (sentences.length < 1) {
            throw new IllegalArgumentException("Text must contain at least one sentence.");
        }

        String[] firstSentenceWords = sentences[0].split("\\s+");

        Set<String> otherSentencesWords = new HashSet<>();
        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");

            for (String word : words) {
                otherSentencesWords.add(word.toLowerCase());
            }
        }

        List<String> uniqueWords = new ArrayList<>();
        for (String word : firstSentenceWords) {
            if (!otherSentencesWords.contains(word.toLowerCase())) {
                uniqueWords.add(word);
            }
        }

        return uniqueWords;

    }
}
