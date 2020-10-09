package jdbc;

import java.sql.*;
import java.util.List;

public class Main3 {

    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "a1bfi5cn";
        final String url = "jdbc:postgresql://localhost:5432/avecoder";
        final String firstName = "'Egor'";
        final String secondName = "'Matveev'";

        String sqlCheckingMyNameInTable = "SELECT * FROM student WHERE second_name = "
         + secondName + " AND first_name = " + firstName + ";";
        String sqlInsertMyName = "INSERT INTO student (" +
                "second_name, first_name, patronymic) VALUES (" +
                 secondName + ", " + firstName + ", 'automated-testing');";

        final Connection connection = DriverManager.getConnection(url, user, password);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCheckingMyNameInTable)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                PreparedStatement preparedStatement1 = connection.prepareStatement(sqlInsertMyName);
                preparedStatement1.execute();
                preparedStatement1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }
}

