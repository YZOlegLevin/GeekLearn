package Java2_HW1;

public class Cat implements Participants {
    private String classNameTranslation;
    private String name;
    private int jumpLimit;
    private double jumpHeightLimit;
    private int runLimit;

    public Cat(String name) {
        this.name = name;
        classNameTranslation = "Котик";
        this.jumpLimit = 20;
        this.runLimit = 500;
        this.jumpHeightLimit = 1.5;
    }

    @Override
    public void run() {
        System.out.println(this.classNameTranslation + " " + this.name + " бежит.");
    }

    @Override
    public void jump() {
        System.out.println(this.classNameTranslation + " " + this.name + " совершает прыжок.");
        this.jumpLimit--;
    }

    @Override
    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
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
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public double getJumpHeightLimit() {
        return jumpHeightLimit;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public void recovery() {
        this.jumpLimit = 20;
        this.runLimit = 500;
    }
}
