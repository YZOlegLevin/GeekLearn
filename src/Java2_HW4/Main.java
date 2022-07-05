package Java2_HW4;

public class Main {
    static final int size = 10_000_000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
         ordinaryMethod();
        System.out.println();
         threadMethod();
    }

    public static void ordinaryMethod() {
        System.out.println("Работает обычный метод");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Медод завершил работу.\nBремя выполнения : " + (System.currentTimeMillis() - a) + " милисекунд");

    }

    public static void threadMethod() {
        System.out.println("Работает многопоточный метод");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            System.out.println("Запустился первый поток");
            float[] first = new float[h];
            System.arraycopy(arr, 0, first, 0, h);
            for (int i = 0; i < first.length; i++) {
                first[i] = (float) (first[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(first, 0, arr, 0, h);
            System.out.println("Первый поток завершил работу");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Запустился второй поток");
            float[] second = new float[h];
            System.arraycopy(arr, 0, second, 0, h);
            for (int i = 0; i < second.length; i++) {
                second[i] = (float) (second[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(second, 0, arr, h, h);
            System.out.println("Второй поток завершил работу");

        });
        Thread t3 = new Thread(() -> {
            try {
                t1.join();
                t2.join();
                System.out.println("Медод завершил работу.\nBремя выполнения : " + (System.currentTimeMillis() - a) + " милисекунд");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t3.start();
        t1.start();
        t2.start();

    }


}




