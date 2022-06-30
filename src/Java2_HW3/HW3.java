package Java2_HW3;

import java.util.ArrayList;
import java.util.List;

public class HW3 {
    public static void main(String[] args) {
        //Task1
        UniqueWords uniqueWords = new UniqueWords();
        System.out.println();
        //Task2
        TelephoneDirectory phones = new TelephoneDirectory();
        phones.add("Петров","+79999999");
        phones.add("Петров","+79888888");
        phones.add("Сидоров","+7977777777");
        phones.add("Козлов","+796666666666");
        phones.get("Петров");
        phones.get("Сидоров");
        phones.get("Козлов");

    }
}
