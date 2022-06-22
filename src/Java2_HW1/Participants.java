package Java2_HW1;

public interface Participants {
    void run();

    void jump();

    void recovery();

    public int getJumpLimit();

    public double getJumpHeightLimit();

    public int getRunLimit();

    public String getClassNameTranslation();

    public String getName();

    public void setRunLimit(int runLimit);

}
