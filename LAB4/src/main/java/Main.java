/*
*  Модифікувати лабораторну роботу №2 наступним чином:
*  для літер, слів, речень, розділових знаків та тексту створити окремі класи.
*  Слово повинно складатися з масиву літер, речення з масиву слів та розділових знаків,
*  текст з масиву речень. Замінити послідовність табуляцій та пробілів одним пробілом.
* 
*  Створити клас, який складається з виконавчого методу, що виконує описану дію з лабораторної роботи №2,
*  але в якості типів використовує створені класи.
*  Код повинен бути детально задокументований.
*  Код повинен відповідати стандартам Java Code Conventions
*  (або Google Java Style Guide) та бути завантаженим на GitHub.
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

                // Replace multiple spaces and tabs with a single space
                inputText = inputText.replaceAll("\\s+", " ");

                Text text = new Text(inputText);
                Word[] uniqueWords = text.findUniqueWords();

                if (uniqueWords != null) {
                    System.out.println("Words that don’t repeat in sentences: " + Arrays.toString(uniqueWords));
                } else {
                    System.out.println("No unique words found.");
                }
                choice = doChoice();
            } while (choice);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to decide whether to repeat the program.
     *
     * @return true if the user wants to repeat, false otherwise
     */
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
}
