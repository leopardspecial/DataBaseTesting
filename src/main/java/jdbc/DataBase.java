package jdbc;


import lombok.Data;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class DataBase {
    public static final String USER = "postgres";
    public static final String PASSWORD = "a1bfi5cn";
    public static final String URL = "jdbc:postgresql://localhost:5432/avecoder";

    private final Connection connection;

    public DataBase(Connection connection) {
        this.connection = connection;
    }

    public boolean selectFromStudentTable(Student student) {
        boolean selectResult = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.SELECT.QUERRY)) {
            preparedStatement.setString(1, student.getSecondName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getPatronymic());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Такого студента ещё не было");
            } else {
                selectResult = true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return selectResult;
    }

    public void insertFromStrudentTable(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.INSERT.QUERRY)) {
            preparedStatement.setString(1, student.getSecondName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getPatronymic());
            preparedStatement.execute();
            System.out.println("The student was successfully added to the table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
