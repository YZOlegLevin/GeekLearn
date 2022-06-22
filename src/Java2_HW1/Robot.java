package Java2_HW1;

public class Robot implements Participants {
    private String classNameTranslation;
    private int jumpLimit;
    private double jumpHeightLimit;
    private int runLimit;
    private String name;

    @Override
    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    Robot(String name) {
        this.name = name;
        classNameTranslation = "Робот";
        this.jumpLimit = 25;
        this.runLimit = 1200;
        this.jumpHeightLimit = 2;
    }

    @Override
    public void run() {
        System.out.println(this.classNameTranslation + " " + this.name + " бежит.");
    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public double getJumpHeightLimit() {
        return jumpHeightLimit;
    }

    @Override
    public String getClassNameTranslation() {
        return classNameTranslation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public void jump() {
        System.out.println(this.classNameTranslation + " " + this.name + " совершает прыжок.");
        this.jumpLimit--;
    }

    public void recovery() {
        this.jumpLimit = 25;
        this.runLimit = 1200;
    }

}
