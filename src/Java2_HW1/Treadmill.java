package Java2_HW1;

import java.util.Random;

public class Treadmill {
    private int distance;
    private Difficult difficult;

    public Treadmill(int distance, Difficult difficult) {
        this.distance = distance;
        this.difficult = difficult;
    }


    public void start(Participants p) {
        Wall wall = new Wall();
        if (this.difficult.equals(Difficult.EASY)) {
            wall.setMaxHeight(1);
        } else if (this.difficult.equals(Difficult.AVERAGE)) {
            wall.setMaxHeight(1.8);
        } else {
            wall.setMaxHeight(2.5);
        }
        Random random = new Random();
        p.run();
        for (int i = 0; i <= this.distance; i++) {
            if (i == this.distance) {
                System.out.println(p.getClassNameTranslation() + " " + p.getName() + " успешно завершает соревноваание");
                break;
            }
            if (p.getRunLimit() == 0) {
                System.out.println(p.getClassNameTranslation() + " " + p.getName() + " больше не межет бежать и завершает соревнование. Пройдено метров : " + i);
                break;
            }
            p.setRunLimit(p.getRunLimit() - 1);
            int newWall = random.nextInt(i, i + 50);
            if (i == newWall) {
                wall.aheadWall();
                double wallHeightRandom = wall.wallHeightRandom();
                wall.setHeight(wallHeightRandom);
                if (p.getJumpHeightLimit() < wall.getHeight()) {
                    System.out.print("Высота стены = " + wall.getHeight() + " метров. ");
                    System.out.println(p.getClassNameTranslation() + " " + p.getName() + " не межет перепрыгнуть стену и завершает соревнование. Пройдено метров : " + i);
                    System.out.println("Максимальный прыжок участника может быть : " + p.getJumpHeightLimit() + " метров.");
                    break;
                } else if (p.getJumpLimit() == 0) {
                    System.out.println(p.getClassNameTranslation() + " " + p.getName() + " исчерпал свой лимит прыжков и завершает соревнование. Пройдено метров : " + i);
                    break;
                }
                System.out.print("Пройдено " + i + " метров. ");
                p.jump();
                System.out.println(p.getClassNameTranslation() + " " + p.getName() + " успешно преодолел стену высотой " + wall.getHeight() + " метров");
                System.out.println("Осталось прыжков : " + p.getJumpLimit());
                System.out.println();
                p.run();
                System.out.println();
            } else {
                continue;
            }

        }

    }
}
