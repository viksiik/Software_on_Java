/* 
*  В залежності від C5 визначити дію, що виконується з матрицею(ями):
*  С5 = 4
*  Дія з матрицею(ями):
*  C = AB
*  де AB — матричний добуток

*  В залежності від C7 визначити тип елементів матриці:
*  C7 = 5
*  Тип елементів матриці:
*  char

*  В залежності від C11 визначити дію з матрицею С:
*  C11 = 8
*  Дія з матрицею С:
*  Знайти середнє значення елементів кожного рядка матриці

*  Створити клас, який складається з виконавчого методу, що
*  виконує дію з матрицею(ями) (п.2) із зазначеним типом елементів (п.3)
*  та дію із результуючою матрицею С (п.4). Вивести на екран результати
*  першої та другої дій. Необхідно обробити всі виключні ситуації,
*  що можуть виникнути під час виконання програмного коду.
*  Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
*  Код повинен відповідати стандартам Java Code Conventions
*  (або Google Java Style Guide) та бути завантаженим на GitHub.
*/

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean choice;

        try {
            do {
                char[][] A = inputMatrix("A");
                System.out.println("Your matrix A:");
                printMatrix(A);

                char[][] B = inputMatrix("B");
                System.out.println("Your matrix B:");
                printMatrix(B);

                char[][] C = multiplyMatrices(A, B);
                System.out.println("Multiplication matrix C:");
                printMatrix(C);

                double[] rowAverages = calculateRowAverages(C);
                System.out.println("Average value (in ASCII) of elements for each row:");
                System.out.println(Arrays.toString(rowAverages));

                choice = doChoice();
            } while (choice);
        } catch(Exception e){
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

    private static char[][] inputMatrix(String matrixName) {
        Scanner scanner = new Scanner(System.in);

        int rows = getPositiveInt(scanner,"Enter number of rows for matrix " + matrixName + ": ");
        int cols = getPositiveInt(scanner,"Enter number of cols for matrix " + matrixName + ": ");

        char[][] matrix = new char[rows][cols];

        System.out.println("Enter elements for matrix " + matrixName + ": ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        return matrix;
    }

    private static int getPositiveInt(Scanner scanner, String message) {
        int number;
        while (true) {
            System.out.print(message);
            try {
                number = scanner.nextInt();
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Error: the value must be positive. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: the value must be integer. Please try again.");
                scanner.next();
            }
        }
        return number;
    }

    private static char[][] multiplyMatrices(char[][] A, char[][] B) throws IllegalArgumentException {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Number of columns matrix B is not " +
                    "equal to number of rows matrix A! Please try again.");
        }

        char[][] C = new char[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += (A[i][k] - '0') *  (B[k][j] - '0');
                }
                C[i][j] = (char) (sum + '0');
            }
        }
        return C;
    }

    private static double[] calculateRowAverages(char[][] matrix) {
        int rows = matrix.length;
        double[] averages = new double[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (char element : matrix[i]) {
                sum += element - '0';
            }
            averages[i] = sum / (double) matrix[i].length;
        }
        return averages;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}