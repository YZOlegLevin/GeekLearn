package Java2_HW1;


public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot("YZ_Bot");
        Cat cat = new Cat("Пушок");
        Human human = new Human("Вася");
        Treadmill treadmill1 = new Treadmill(500,Difficult.EASY);
        Treadmill treadmill2 = new Treadmill(850,Difficult.AVERAGE);
        Treadmill treadmill3 = new Treadmill(1200,Difficult.HARD);
        Participants[] participants = {robot,cat,human};
        Treadmill[] treadmills = {treadmill1,treadmill2,treadmill3};
        for (int i = 0; i < treadmills.length; i++) {
            for (int j = 0; j < participants.length; j++) {
                System.out.println(participants[j].getClassNameTranslation()+" "+participants[j].getName() + " начинает соревнование.");
                treadmills[i].start(participants[j]);
                System.out.println();
                System.out.println(participants[j].getName() + " отдыхает");
                participants[j].recovery();
                System.out.println();
            }

        }


    }


}

