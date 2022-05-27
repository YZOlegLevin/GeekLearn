package HomeWork5;

public class Employee {
    private String fnp;
    private String post;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fnp, String post, String email, String phone, double salary, int age) {
        this.fnp = fnp;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Данные о сотруднике :\n" + "ФИО - " + fnp + "\n" + "Должность - " + post + "\n" + "e-mail - " + email + "\n" + "Телефон - " + phone + "\n" +
                "Заработная плата - " + salary + "\n" +
                "Возраст - " + age;
    }
}

