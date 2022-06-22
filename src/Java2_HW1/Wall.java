package Java2_HW1;

import java.util.Random;

public class Wall {
    private double height;
    private double maxHeight;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void aheadWall() {
        System.out.println("Впереди стена !");
    }

    Wall(){
        this.height = 0;
    }
    Random random = new Random();

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double wallHeightRandom(){
        double wallHeightRandom = random.nextDouble(0.3,this.maxHeight);
        char num;
        String value = String.valueOf(wallHeightRandom);
        String value2 = "";
        double result;
        for (int i = 0; i < 3; i++) {
            num = value.charAt(i);
            value2 += num;
        }
        result = Double.parseDouble(value2);
        return result;
    }
}
