package HomeWork7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        Cat cat1 = new Cat("Пушок", "мАлЕнький");
        Cat cat2 = new Cat("Снежок", "большой");
        Cat cat3 = new Cat("Барсик", "маленький");
        Cat cat4 = new Cat("Рыжик", "мАлЕнький");
        Cat cat5 = new Cat("Васька", "большой");
        Cat cat6 = new Cat("Мурзик", "??");
        Cat cat7 = new Cat("Шмурзик", "маленький");
        Cat cat8 = new Cat("Петька", "Средний");
        BowlOfFood bowl1 = new BowlOfFood(48);
        bowl1.setAmountOfFood(-2);
        bowl1.setAmountOfFood(-100000);
        bowl1.setAmountOfFood(5000);
        bowl1.setAmountOfFood(-3);
        BowlOfFood bowl2 = new BowlOfFood(39);
        bowl2.setAmountOfFood(4);
        System.out.println();
        Cat[] cats = new Cat[8];
        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = cat3;
        cats[3] = cat4;
        cats[4] = cat5;
        cats[5] = cat6;
        cats[6] = cat7;
        cats[7] = cat8;

        while (bowl1.getAmountOfFood() + bowl2.getAmountOfFood() != 0) {
            if (bowl1.getAmountOfFood() != 0) {
                cats[random.nextInt(8)].eat(bowl1);
            } else cats[random.nextInt(8)].eat(bowl2);
        }

        for (int i = 0; i < cats.length; i++) {
            cats[i].isSatiety();
        }
        Dog dog1 = new Dog("Майк", "Большой");
        dog1.printInfo();
        dog1.hunt(cats);

    }


}

