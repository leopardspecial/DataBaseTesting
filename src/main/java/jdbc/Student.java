package jdbc;


public class Student {
    private final String firstName;
    private final String secondName;
    private final String patronymic;

    public Student(String firstName, String secondName, String patronymic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
