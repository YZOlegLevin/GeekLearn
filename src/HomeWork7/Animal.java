package HomeWork7;

public class Animal {
    private String name;
    private String size;
    private static int animalCount;
    private int hungerLevel;
    private boolean satiety;

    public boolean isSatiety() {
        if (this.hungerLevel == 0) {
            System.out.println(name + " сыт :)");
            satiety = true;
        } else {
            System.out.println(name + " голоден :(");
            System.out.println("Уровень голода = " + this.hungerLevel);
            satiety = false;
        }
        System.out.println();
        return satiety;
    }

    public Animal(String name, String size) {
        this.name = name;
        this.size = checkSize(size);
        this.hungerLevel = checkHungerLevel(this.size);
        animalCount++;
        System.out.println("Создано животное № " + getAnimalCount());
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров.");

    }

    public void printInfo() {
        System.out.println(this);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = checkSize(size);
    }

    @Override
    public String toString() {
        return "Неизвестное животное :\n" + "Имя - " + name + "\n" + "Размер - " + size + "\nУровень голода - " + this.getHungerLevel();
    }

    private static String correctCase(String str) {
        String s1 = str;
        String s2 = s1.toUpperCase();
        char first = s2.charAt(0);
        s2 = s2.substring(1).toLowerCase();
        s1 = first + s2;
        return s1;
    }

    private static String checkSize(String str) {
        str = correctCase(str);
        String[] sizes = {"Большой", "Средний", "Маленький"};
        int sizeCount = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (str.equals(sizes[i])) {
                sizeCount++;
                return str;
            }
        }
        if (sizeCount == 0)
            System.out.println("Размер животного может быть 'Маленький, 'Средний' или 'Большой', по умолчанию установлено значение 'Средний'.");
        return "Средний";

    }

    private static int checkHungerLevel(String str) {
        int hungerLevel = 0;
        if (str.equals("Большой")) {
            hungerLevel = 3;
            return hungerLevel;
        } else if (str.equals("Средний")) {
            hungerLevel = 2;
            return hungerLevel;
        } else {
            hungerLevel = 1;
            return hungerLevel;
        }
    }

    public int getHungerLevel() {
        return this.hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        if (hungerLevel < 0 || hungerLevel > 60) {
            System.out.println("Доступные значения от 0 до 60. Уровень голода остался без изменений.");
        } else {
            this.hungerLevel = hungerLevel;
        }
    }

    public void eat(BowlOfFood bowl) {

    }
}

