package HomeWork7;

public class Cat extends Animal {
    private String animalClass;
    private static int catsCount;
    private int hungerCoeficent = 10;


    public Cat(String name, String size) {
        super(name, size);
        animalClass = "Кот";
        catsCount++;
        this.setHungerLevel(getHungerLevel() * hungerCoeficent);
        System.out.println("Создан кот № " + getCatsCount());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Животное : " + animalClass + "\nИмя - " + this.getName() + "\nРазмер - " + this.getSize() + "\nУровень голода - " + this.getHungerLevel();
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(this.getName() + " сделал всё что мог...");
            distance = 200;
            System.out.println(animalClass + " " + this.getName() + " пробежал " + distance + " метров.");
        } else if (distance < 1) {
            System.out.println(animalClass + " " + this.getName() + " остался на месте");
        } else {
            System.out.println(animalClass + " " + this.getName() + " пробежал " + distance + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(animalClass + " " + this.getName() + " боится воды.");
    }


    public static int getCatsCount() {
        return catsCount;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    @Override
    public void eat(BowlOfFood bowl) {
        int foodInABowl = bowl.getAmountOfFood();
        int hunger = this.getHungerLevel();
        if (hunger == 0) {
        } else if (foodInABowl - hunger >= 0) {
            setHungerLevel(0);
            foodInABowl -= hunger;
            bowl.setEat(foodInABowl);
        } else if (foodInABowl - hunger < 0) {
            bowl.setEat(0);
            hunger -= foodInABowl;
            setHungerLevel(hunger);
        }
    }


}
