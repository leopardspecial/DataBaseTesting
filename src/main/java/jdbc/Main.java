package jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String user = "postgres";
        final String password = "a1bfi5cn";
        final String url = "jdbc:postgresql://localhost:5432/avecoder";
        String sqlCreateMyTable = "CREATE TABLE mystudent (id INT, second_name VARCHAR(50), " +
                "first_name VARCHAR(50))";
        String sqlInsertIntoMyStudent = "INSERT INTO mystudent VALUES('Matveev', 'Egor');";
        String sqlInsertIntoStudent = "INSERT INTO student SELECT 'Matveev', 'Egor' FROM mystudent WHERE " +
                "NOT EXISTS(SELECT * FROM student WHERE second_name = 'Matveev' AND first_name = " +
                "'Egot');";


        final Connection connection = DriverManager.getConnection(url, user, password);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateMyTable)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertIntoMyStudent)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertIntoStudent)) {
            preparedStatement.execute();
    }

    }
}
