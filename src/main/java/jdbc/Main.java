package jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String USER = "postgres";
        final String PASSWORD = "a1bfi5cn";
        final String URL = "jdbc:postgresql://localhost:5432/avecoder";

        Student student = new Student("Egor", "Matveev", "Victorovich");

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            ResultSet resultSet = createPreparedStatement(connection, student, SQLCommand.SELECT)
                    .executeQuery();

            if (resultSet.next()) {
                System.out.println("Такой студент уже есть в таблице");
            } else {
                createPreparedStatement(connection, student, SQLCommand.INSERT)
                        .execute();
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static PreparedStatement createPreparedStatement(Connection connection, Student student, SQLCommand select) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(select.query);
        preparedStatement.setString(1, student.getSecondName());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getPatronymic());
        return preparedStatement;
    }
}
