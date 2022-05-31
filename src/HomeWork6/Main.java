package HomeWork6;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        Dog dog1 = new Dog("Шарик", "Маленький");
        System.out.println();
        dog1.printInfo();
        dog1.run(450);
        System.out.println();
        Cat cat1 = new Cat("Барсик", "Большой");
        cat1.printInfo();
        cat1.run(300);
        System.out.println();
        Animal cat2 = new Cat("Пушок","Маленький");
        cat2.printInfo();
        cat2.swim(20);
        System.out.println();
        Animal dog2 = new Dog("Снежок","Непонятно");
        System.out.println();
        dog2.printInfo();
        dog2.swim(20);
        System.out.println();
        Animal uncnownAnimal = new Animal("Гермес","Большой");
        uncnownAnimal.printInfo();
        uncnownAnimal.run(1000);


    }


}

