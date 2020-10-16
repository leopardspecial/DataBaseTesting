package jdbc;

public enum SQLCommand {
    SELECT("SELECT * FROM student WHERE second_name = (?) AND first_name = (?) AND patronymic = (?)"),
    INSERT("INSERT INTO student (second_name, first_name, patronymic) VALUES ((?), (?), (?))");

    String query;

    SQLCommand(String query) {
        this.query = query;
    }
}
