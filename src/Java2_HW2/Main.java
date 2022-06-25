package Java2_HW2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean bool = true;
        String[][] newArray = createRandomStingArray(-10,600000);
        printStringArray(newArray);
        sumOfElems(newArray);

    }

    public static String[][] createRandomStingArray(int lines, int columns) {
        try {
            if (lines != 4 || columns != 4) {
                throw new MyArraySizeException("Данный массив долежн быть размером 4 х 4 !\sЗначения, определяющие размер массива были изменены на корректные.");
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            lines = 4;
            columns = 4;
        }
        String[][] myArray = new String[lines][columns];
        Random random = new Random();
        String str = "";
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                int elem;
                for (int k = 0; k < random.nextInt(1, 6); k++) {
                    elem = random.nextInt(46, 68);
                    str += (char) elem;
                }
                myArray[i][j] = str;
                str = "";
            }

        }
        return myArray;
    }

    public static void printStringArray(String[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static String stringCorrector(String str) {
        String intsInString = "";
        int intInString = 0;
        char current;
        for (int i = 0; i < str.length(); i++) {
            current = str.charAt(i);
            try {
                if (current >= 48 && current < 58) {
                    intInString = Integer.parseInt(String.valueOf(current));
                    intsInString += String.valueOf(intInString);
                } else {
                    throw new MyArrayDataException("Обнаружен символ " + "'" + current + "'" + " не являющийся цифрой и будет проигнорирован");
                }
            } catch (MyArrayDataException e) {
                e.printStackTrace();
                continue;
            }

        }
        if (intsInString.equals("")) intsInString = "0";
        return intsInString;
    }

    public static int sumOfElems(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String intsInString = "";
                for (int k = 0; k < array[i][j].length(); k++) {
                    int intInString = 0;
                    char current;
                    current = array[i][j].charAt(k);
                    try {
                        if (current >= 48 && current < 58) {
                            intInString = Integer.parseInt(String.valueOf(current));
                            intsInString += String.valueOf(intInString);
                        } else {
                            throw new MyArrayDataException("В элементе массива " + i + " : " + j + " oбнаружен символ " + "'" + current + "'" + " не являющийся цифрой и будет проигнорирован");
                        }
                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                        continue;
                    }


                    if (intsInString.equals("")) intsInString = "0";

                }
                if (intsInString.equals("")) intsInString = "0";
                array[i][j] = intsInString;
            }
        }
        System.out.println("Измененный массив");
        printStringArray(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += Integer.parseInt(stringCorrector(array[i][j]));
            }
        }
        System.out.println("Cумма всех элементов = " + sum);
        return sum;
    }


}

