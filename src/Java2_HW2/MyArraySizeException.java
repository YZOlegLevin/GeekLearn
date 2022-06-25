package Java2_HW2;

public class MyArraySizeException extends IllegalArgumentException{
    public MyArraySizeException(String s) {
        super(s);
    }

    public MyArraySizeException() {
        System.out.println(" Данный массив долежн быть размером 4 х 4 ! ");
        System.out.println("Значения, определяющие размер массива были изменены на корректные.");
    }
}
