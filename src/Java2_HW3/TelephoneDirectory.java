package Java2_HW3;

import java.util.*;

public class TelephoneDirectory {
    private HashMap<String, List<String>> emploees = new LinkedHashMap<>();
    private List<String> numbers;


    public void add(String familyName, String phone) {
        if (emploees.containsKey(familyName)) {
        numbers = emploees.get(familyName);
        numbers.add(phone);
        }

        else {numbers = new ArrayList<>();
            numbers.add(phone);
         emploees.put(familyName, numbers);}
    }


    public void get(String familyName) {
        System.out.println(familyName + ": " + emploees.get(familyName));
    }




}



