package HomeWork7;

public class BowlOfFood {
    private int amountOfFood;
    private static int bowlCount;
    private int numberOfBowl;

    public BowlOfFood(int amountOfFood) {
        if (amountOfFood > 50) {
            System.out.println("В миске не может быть больше 50 едениц корма. Значение изменено на максимальное.");
            amountOfFood = 50;
            this.amountOfFood = amountOfFood;
            bowlCount++;
            this.numberOfBowl = bowlCount;
            System.out.println("Создана миска для еды № " + bowlCount + " с количетсвом еды = " + amountOfFood);
        } else if (amountOfFood < 0) {
            System.out.println("В меиске не может быть отрицательное количество еды. Значение изменено на 0");
            amountOfFood = 0;
            this.amountOfFood = amountOfFood;
            bowlCount++;
            this.numberOfBowl = bowlCount;
            System.out.println("Создана миска для еды № " + bowlCount + " с количетсвом еды = " + amountOfFood);
        } else {
            this.amountOfFood = amountOfFood;
            bowlCount++;
            this.numberOfBowl = bowlCount;
            System.out.println("Создана миска для еды № " + bowlCount + " с количетсвом еды = " + amountOfFood);
        }
    }

    @Override
    public String toString() {
        return "Миска для еды № " + numberOfBowl + "\nКоличество еды = " + amountOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void printInfo() {
        System.out.println(this);
        System.out.println();
    }

    public void setAmountOfFood(int amountOfFood) {
        if (amountOfFood == 0) {
            System.out.println("В миску № " + numberOfBowl + " еда не добавлена !");
        } else if (this.amountOfFood + amountOfFood >= 50) {
            System.out.println("Добавили еду в миску № " + numberOfBowl + ", тепеь там максимальное количество еды.");
            this.amountOfFood = 50;
        } else if (amountOfFood < 0) {
            if (this.amountOfFood + amountOfFood < 0) {
                System.out.println("В миске № " + numberOfBowl + " больше нет еды :(");
                this.amountOfFood = 0;
            } else {
                System.out.println("Из миски № " + numberOfBowl + " убавилось еды");
                this.amountOfFood += amountOfFood;
                System.out.println("Количество еды = " + this.amountOfFood);
            }
        } else {
            this.amountOfFood += amountOfFood;
            System.out.println("В миску № " + numberOfBowl + " добавлена еда. Количество еды = " + this.amountOfFood);
        }
    }

    public void setEat(int eat) {
        this.amountOfFood = eat;
    }
}


