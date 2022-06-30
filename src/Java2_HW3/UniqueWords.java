package Java2_HW3;

import java.util.ArrayList;
import java.util.List;

public class UniqueWords {

    UniqueWords() {
        List<String> list = new ArrayList<>();
        list.add("Петя");
        list.add("Маша");
        list.add("Коля");
        list.add("Алиса");
        list.add("Толя");
        list.add("Ирина");
        list.add("Алиса");
        list.add("Петя");
        list.add("Маша");
        list.add("Ирина");
        list.add("Алиса");
        list.add("Саша");
        list.add("Софья");
        list.add("Алиса");
        list.add("Петя");
        list.add("Валерия");
        list.add("Алиса");
        ((ArrayList<String>) list).trimToSize();
        List<String> listCopy = new ArrayList<>(list);


        for (int i = 0; i < listCopy.size(); i++) {
            int nameCount = 1;
            for (int j = 0; j < listCopy.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (listCopy.get(i).equals(listCopy.get(j))) {
                    nameCount++;
                    listCopy.remove(j);
                }

            }
            if (nameCount >= 2 && nameCount <= 4)
                System.out.println("Имя " + listCopy.get(i) + "\t\tвстречается " + nameCount + " раза");
            else System.out.println("Имя " + listCopy.get(i) + "\t\tвстречается " + nameCount + " раз");

        }
        listCopy = null;
    }
}
