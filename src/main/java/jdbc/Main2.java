package jdbc;

import javax.xml.crypto.Data;
import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        Student student = new Student("Egorii", "Matveev", "Victorovich");

        Connection connection = DriverManager.getConnection(DataBase.URL, DataBase.USER, DataBase.PASSWORD);

        DataBase dataBase = new DataBase(connection);

        if (dataBase.selectFromStudentTable(student)) {
            System.out.println("Такой студент уже есть в таблице");
        } else {
            dataBase.insertFromStrudentTable(student);
            System.out.println("Студент добавлен");
        }

    }
}
