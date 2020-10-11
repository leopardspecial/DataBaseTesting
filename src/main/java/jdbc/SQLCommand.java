package jdbc;

public enum SQLCommand {
    SELECT("SELECT * FROM student WHERE second_name = (?) AND first_name = (?)"),
    INSERT("INSERT INTO student (second_name, first_name, patronymic) VALUES ((?), (?), 'automation testing')");

    String QUERRY;
    SQLCommand(String QUERRY) {
        this.QUERRY = QUERRY;
    }
}
