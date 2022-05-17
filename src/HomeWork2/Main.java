package HomeWork2;

public class Main {
    public static void main(String[] args) {
        //Вызовите метод
    }

    //Метод можно отобразить в конслои например
    //System.out.println(checkSum(0,0));
    static boolean checkSum(int num1, int num2) {
        if (num1 + num2 >= 10 && num1 + num2 <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static void checkValue(int value) {
        if (value < 0) System.out.println("Число " + value + " отрицательное !");
        else System.out.println("Число " + value + " положительное !");
    }

    //Перегрузил метод из 1 задания
    static boolean checkSum(int value) {
        if (value < 0) {
            return true;
        } else {
            return false;
        }
    }

    static void printString(String text, int iterations) {
        for (int i = 0; i < iterations; i++) {
            System.out.println(text);
        }
    }

    static boolean checkLeapYear(int year) {
        int num4 = 4;
        int num100 = 100;
        int num400 = 400;
        for (int i = 0; i < year; i++) {
            if (i == num4) num4 += 4;
            if (i == num100) num100 += 100;
            if (i == num400) num400 += 400;
        }
        if (year == num4 || year == num400 && year != num100) {
            return true;
        } else {
            return false;
        }

    }
}
