package hwa;

public class Hwa {
    public static void main(String[] args) {

    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Aplle");
        System.out.println("Banana");
    }

    static void checkSumSign(int a, int b) {
        int value = a + b;
        if (value >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    static void printColor(int value) {
        if (value <= 0) System.out.println("Красный");
        else if (value > 0 && value <= 100) System.out.println("Жёлтый");
        else System.out.println("Зелёный");
    }

    static void compareNumbers(int a, int b) {
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
