package HomeWork5;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        //Поле phone в формате стринг потому что в инт не помещаются такие числа, а если делать лонг то не получится начать номер с +7
        Employee emp1 = new Employee("Левин Олег Игоревич", "Ведущий специалист", "yarzar@gmail.com", "+79951007588", 70000.25, 26);
        Employee emp2 = new Employee("Иванов Иван Ивонович", "Эксперт", "ivan@mail.ru", "+79999999999", 85100.50, 46);
        Employee emp3 = new Employee("Сидоров Сидор Сидорович", "Младжий специалист", "sidor@mail.ru", "+78888888888", 50000, 23);
        Employee emp4 = new Employee("Петров Пётр Петрович", "Старший специалист", "petr@mail.ru", "+77777777777", 65100.50, 51);
        Employee emp5 = new Employee("Николаев Николай Николаевич", "Эксперт", "nikolai@mail.ru", "+76666666666", 85100.50, 38);

        employees[0] = emp1;
        employees[1] = emp2;
        employees[2] = emp3;
        employees[3] = emp4;
        employees[4] = emp5;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println();
                System.out.println(employees[i]);
                System.out.println();
            }

        }
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


}

