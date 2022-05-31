package HomeWork6;

public class Animal {
    protected String name;
    protected String size;
    static int animalCount;


    public Animal(String name, String size) {
        this.name = name;
        if ("Маленький".equalsIgnoreCase(size)){
        this.size = size;}
        else if ("Средий".equalsIgnoreCase(size)){
        this.size = size;}
        else if ("Большой".equalsIgnoreCase(size)){
        this.size = size;}
        else {
            System.out.println("Размер животного может быть 'Маленький, 'Средний' или 'Большой', по умолчанию установлено значение 'Средний'.");
            this.size = "Средний";
        }
        animalCount++;
        System.out.println("Создано животное № " + getAnimalCount());
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance){
        System.out.println(name + " пробежал " + distance + " метров.");
    }
    public void swim(int distance){
        if (this instanceof Cat){
            System.out.println(name +" боится воды");
        }
        else {
        System.out.println(name + " проплыл " + distance + " метров.");}
    }

    public void printInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Неизвестное животное :\n" + "Имя - " + name + "\n" + "Размер - " + size;
    }
}

