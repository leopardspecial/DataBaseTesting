package jdbcTest;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import jdbc.DataBase;
import jdbc.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class StudentTest {
    private Student student;
    private Connection connection;
    private DataBase dataBase;
    private boolean checkResult = true;

    @Дано("^создаём студента c именем \"([^\"]*)\" и фамилией \"([^\"]*)\"$")
    public void createStudent(String firstName, String secondName) {
        student = new Student(firstName, secondName);
    }

    @Дано("^создаём соединение с базой данных$")
    public void createConnection() throws SQLException {
        connection = DriverManager.getConnection(DataBase.URL, DataBase.USER, DataBase.PASSWORD);
    }

    @Дано("^создаём базу данных$")
    public void createDataBase() {
        dataBase = new DataBase(connection);
    }

    @Когда("^проверяем наличие студента в базе данных$")
    public void checkStudentInDataBase() {
        checkResult = dataBase.selectFromStudentTable(student);
    }

    @То("^добавляем его, если отсутствует$")
    public void insertStudentInDataBase() {
        if (!checkResult) {
            dataBase.insertFromStrudentTable(student);
        } else {
            System.out.println("This student is already in the table");
        }
    }

    @И("^закрываем соединение$")
    public void closeConnection() throws SQLException {
        connection.close();
    }

}