package HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ЧТОБЫ ПРОВЕРИТЬ ЗАДАНИЕ ВЫЗОВЕТЕ ОДИН ИЗ МЕТОДОВ task
    }

    static int intScan() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Введите целое число");
                scanner.next();
            }
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[] createRandomIntArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max);
        }

        return array;
    }

    static int[] createArray(int len, int initialValue) {
        int array[] = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }


    static boolean checkBalance(int[] array) {
        System.out.println("Заданный массив");
        printArray(array);
        int balance = 0;
        for (int i = 0; i < array.length; i++) {
            balance += array[i];
        }
        System.out.println();
        System.out.printf("Cумма элементов массива = %d", balance);
        System.out.println();

        if (balance % 2 != 0) {
            System.out.println("Нет места, в котором сумма левой и правой части массива равны.");
            return false;
        } else {
            int leftValue = 0;
            int rightValue = 0;
            balance /= 2;
            for (int i = 0; i < array.length; i++) {
                if (leftValue < balance) leftValue += array[i];
                if (leftValue > balance) leftValue -= array[i];
                if (rightValue < balance) rightValue += array[array.length - 1 - i];
                if (rightValue > balance) rightValue -= array[array.length - 1 - i];
                if (leftValue == rightValue) {
                    System.out.println("Есть место, в котором сумма левой и правой части массива равны.");
                    System.out.println("Сумма алементов слева = " + leftValue + "\t" + "Сумма элементов справа = " + rightValue);
                    return true;
                }
            }
            System.out.println("Нет места, в котором сумма левой и правой части массива равны.");
            System.out.println("Сумма алементов слева = " + leftValue + "\t" + "Сумма элементов справа = " + rightValue);
            return false;
        }

    }


    static void task1() {
        System.out.println("Введите количество элементов в массиве");
        int arrayLength = intScan();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            double rnd = Math.random();
            if (rnd <= 0.5) rnd = 0;
            else rnd = 1;
            array[i] = (int) rnd;
        }
        System.out.println("Изначальный массив");
        printArray(array);
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        System.out.println();
        System.out.println("Изменённый массив");
        printArray(array);
    }

    static void task2() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        printArray(array);
    }

    static void task3() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Изначальный массив");
        printArray(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        System.out.println();
        System.out.println("Изменённый массив");
        printArray(array);
    }

    static void task4() {
        System.out.println("Задайте кол-во строк и столбцов одной цифрой, их кол-во одинаковое");
        int size = intScan();
        int[][] array = new int[size][size];
        // printArray(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i) array[i][j] = 1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (j == array.length - i - 1) array[i][j] = 1;
            }
        }
        printArray(array);
    }

    static int[] task5() {
        System.out.println("Задайте параметры массива(целые числа)");
        System.out.println("Введите длинну массива");
        int len = intScan();
        System.out.println("Введите значение, которым будут проинициализированы элементы массива");
        int initialValue = intScan();
        int[] newArray = createArray(len, initialValue);
        printArray(newArray);
        return newArray;
    }


    static void task6() {
        System.out.println("Чтобы задать длинну одномерного массива введите целое число");
        int size = intScan();
        int[] array = new int[size];
        System.out.println("Заданный массив");
        array = createRandomIntArray(size, 0, 100);
        printArray(array);
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
            if (max < array[i]) max = array[i];
        }
        System.out.println();
        System.out.printf("Минимальный объект = %d", min);
        System.out.println();
        System.out.printf("Максимальный объект = %d", max);
    }

    static void task7() {
        System.out.println("Создаём случайный массив, задайте размер, минимальное и максимальное значение");
        int[] newArray;
        System.out.println("Размер");
        int size = intScan();
        System.out.println("Минимальне значение");
        int min = intScan();
        System.out.println("Максимальное значение");
        int max = intScan();
        newArray = createRandomIntArray(size, min, max);
        checkBalance(newArray);


    }

    static void task8() {
        System.out.println("Создаём случайный массив, задайте размер, минимальное и максимальное значение");
        int[] newArray;
        System.out.println("Размер");
        int size = intScan();
        System.out.println("Минимальне значение");
        int min = intScan();
        System.out.println("Максимальное значение");
        int max = intScan();
        System.out.println("Введите число n, на которое будем смещать массив");
        int n = intScan();
        newArray = createRandomIntArray(size, min, max);
        System.out.println("Изначальный массив");
        printArray(newArray);
        System.out.println();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int temp = newArray[newArray.length - 1];
                for (int j = newArray.length - 1; j > 0; j--) {
                    newArray[j] = newArray[j - 1];
                }
                newArray[0] = temp;
            }
        } else {
            for (int i = 0; i > n; i--) {
                int temp = newArray[0];
                for (int j = 1; j < newArray.length; j++) {
                    newArray[j - 1] = newArray[j];
                }
                newArray[newArray.length - 1] = temp;
            }
        }
        System.out.println();
        System.out.println("Изменённый массив");
        printArray(newArray);
    }
}

