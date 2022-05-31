package HomeWork6;

public class Dog extends Animal {
    private String animalClass;
    static int dogsCount;

    public Dog(String name, String size) {
        super(name, size);
        animalClass = "Собака";
        dogsCount++;
        System.out.print("Создана собака № "+ getDogsCount());
    }

    @Override
    public String toString() {
        return "Животное : " + animalClass + "\nИмя - " + name + "\nРазмер - " + size;
    }
    @Override
    public void run(int distance){
        if (distance > 500) {
            System.out.println(name+" сделал всё что мог...");
            distance = 500;
            System.out.println(animalClass+" "+name + " пробежал " + distance + " метров.");
        }
        else if (distance < 1){
            System.out.println(animalClass+" "+name + " остался на месте");
        }
        else {System.out.println(animalClass+" "+name + " пробежал " + distance + " метров.");}
    }

    @Override
    public void swim(int distance){
        if (distance > 10) {
            System.out.println(name+" сделал всё что мог...");
            distance = 10;
            System.out.println(animalClass+" "+name + " проплыл " + distance + " метров.");
        }
        else if (distance < 1){
            System.out.println(animalClass+" "+name + " остался на месте");
        }
        else {System.out.println(animalClass+" "+name + " проплыл " + distance + " метров.");}
    }

    public static int getDogsCount(){
        return dogsCount;
    }
}
