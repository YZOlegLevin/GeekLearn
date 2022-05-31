package HomeWork6;

public class Cat extends Animal{
    private String animalClass;
    static int catsCount;


    public Cat(String name, String size) {
        super(name, size);
        animalClass = "Кот";
        catsCount++;
        System.out.println("Создан кот № "+ getCatsCount());
    }
    @Override
    public String toString() {
        return "Животное : " + animalClass + "\nИмя - " + name + "\nРазмер - " + size;
    }
    @Override
    public void run(int distance){
        if (distance > 200) {
            System.out.println(name+" сделал всё что мог...");
            distance = 200;
            System.out.println(animalClass+" "+name + " пробежал " + distance + " метров.");
        }
        else if (distance < 1){
            System.out.println(animalClass+" "+name + " остался на месте");
        }
        else {System.out.println(animalClass+" "+name + " пробежал " + distance + " метров.");}
    }





    public static int getCatsCount(){
        return catsCount;
    }
}
