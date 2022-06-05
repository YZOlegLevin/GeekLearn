package HomeWork7;

import java.util.Random;

public class Dog extends Animal {
    private static Random random = new Random();
    private String animalClass;
    static int dogsCount;
    private int hungerCoeficent = 20;

    public Dog(String name, String size) {
        super(name, size);
        animalClass = "Собака";
        dogsCount++;
        this.setHungerLevel(getHungerLevel() * hungerCoeficent);
        System.out.println("Создана собака № " + getDogsCount());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Животное : " + animalClass + "\nИмя - " + this.getName() + "\nРазмер - " + this.getSize() + "\nУровень голода - " + this.getHungerLevel();
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(this.getName() + " сделал всё что мог...");
            distance = 500;
            System.out.println(animalClass + " " + this.getName() + " пробежал " + distance + " метров.");
        } else if (distance < 1) {
            System.out.println(animalClass + " " + this.getName() + " остался на месте");
        } else {
            System.out.println(animalClass + " " + this.getName() + " пробежал " + distance + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(this.getName() + " сделал всё что мог...");
            distance = 10;
            System.out.println(animalClass + " " + this.getName() + " проплыл " + distance + " метров.");
        } else if (distance < 1) {
            System.out.println(animalClass + " " + this.getName() + " остался на месте");
        } else {
            System.out.println(animalClass + " " + this.getName() + " проплыл " + distance + " метров.");
        }
    }

    public static int getDogsCount() {
        return dogsCount;
    }

    public void eat(Cat cat) {
        int sizeOfCat = 0;
        if (cat.getSize().equals("Большой")) {
            sizeOfCat = 30;
        } else if (cat.getSize().equals("Средний")) {
            sizeOfCat = 20;
        } else {
            sizeOfCat = 10;
        }
        int hunger = this.getHungerLevel();
        hunger -= sizeOfCat;
        if (hunger >= 0) {
            System.out.println(getName() + " съел другое животное : " + cat.getAnimalClass() + " " + cat.getName() + " !");
            this.setHungerLevel(hunger);
        }
    }

    public void hunt(Cat[] cats) {
        System.out.println(this.getName() + " начинает охотиться");
        for (int i = 0; i < cats.length; i++) {
            while (true) {
                int catNum = random.nextInt(0, cats.length);
                if (cats[catNum] == null) {
                    continue;
                }
                this.eat(cats[catNum]);
                cats[catNum] = null;
                break;
            }

        }
        System.out.println();
        this.isSatiety();
    }
}

