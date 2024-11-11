/*
*  В залежності від C11 визначити варіант завдання:
*  C11 = 8
*  Варіант завдання
*  Визначити клас студент, який складається як мінімум з 5-и полів.

*  Створити клас із виконавчим методом, в якому створити
*  масив з об’єктів класу визначеному варіантом (п. 2).
*  Відсортувати масив, за одним з полів за зростанням, а за іншим — за спаданням,
*  використовуючи при цьому стандартні засоби сортування ().
*  Після цього знайти в масиві об’єкт, який ідентичний заданому.
*  Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
*  Код повинен бути детально задокументований. Код повинен відповідати стандартам
*  Java Code Conventions (або Google Java Style Guide) та бути завантаженим на GitHub.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create the array of students
        Student[] students = {
                new Student("Alice", "Maclaren", 18, "Female", 2),
                new Student("Bob", "Cawasaki", 20, "Male", 3),
                new Student("Charlie", "Di", 19, "Female", 2),
                new Student("Edward", "Hoggins", 17, "Male", 2),
                new Student("Diana", "Supre", 22, "Female", 4)
        };

        // Sort the array of students
        sortStudents(students);

        // Define the target student to search for
        Student targetStudent = new Student("Alice", "Maclaren", 18, "Female", 2);

        boolean found = Arrays.asList(students).contains(targetStudent);

        // Output the search results
        System.out.println("\nSearching for " + targetStudent);
        System.out.println("Found: " + (found ? "Yes" : "No"));
    }

    /**
     * Sorts an array of students based on two fields entered by user and orders.
     *
     * @param students the array of students to be sorted
     */

    private static void sortStudents(Student[] students) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the primary sorting field
        System.out.println("Choose primary sorting field (firstname, lastname, age, gender, course): ");
        String primaryField = scanner.nextLine().toLowerCase();
        String primaryOrder = "asc";

        // Prompt the user to enter the secondary sorting field
        System.out.println("Choose secondary sorting field (firstname, lastname, age, gender, course): ");
        String secondaryField = scanner.nextLine().toLowerCase();
        String secondaryOrder = "desc";

        // Get a comparator based on the fields and orders provided by the user
        Comparator<Student> comparator = getComparator(primaryField, primaryOrder)
                .thenComparing(getComparator(secondaryField, secondaryOrder));

        // Sort the students array using the constructed comparator
        Arrays.sort(students, comparator);

        System.out.println("Sorted students by " + primaryField + " and " + secondaryField + ":");
        for (Student student : students) {
            System.out.println(student);
        }

    }

    /**
     * Creates a comparator for a given field and order.
     *
     * @param field the field to sort by (firstname, lastname, age, gender, course)
     * @param order the sorting order ("asc" for ascending, "desc" for descending)
     * @return Comparator<Student> a comparator for sorting students by the specified field and order
     */
    private static Comparator<Student> getComparator(String field, String order) {
        Comparator<Student> comparator;

        switch (field) {
            case "firstname" -> comparator = Comparator.comparing(Student::getFirstName);
            case "age" -> comparator = Comparator.comparingInt(Student::getAge);
            case "lastname" -> comparator = Comparator.comparing(Student::getLastName);
            case "gender" -> comparator = Comparator.comparing(Student::getGender);
            case "course" -> comparator = Comparator.comparingInt(Student::getCourse);
            default -> throw new IllegalArgumentException("Invalid field: " + field);

        };

        // Reverse the comparator if the order is descending
        if (order.equals("desc")) {
            comparator = comparator.reversed();
        }

        return comparator;
    }

}