package jdbc;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String user = "docker";
        final String password = "docker";
        final String url = "jdbc:postgresql://192.168.1.103:32768/student";
        String sqlCheckingMyNameInTable = "SELECT * FROM student";
        String sqlInsertMyName = "INSERT INTO student (" +
                "id, second_name, first_name, patronymic) VALUES (" +
                "2, 'Matveev', 'Egor', 'automated-testing');";

        final Connection connection = DriverManager.getConnection(url, user, password);
//        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (" +
//                "second_name, first_name, patronymic) VALUES (" +
//                "'Matveev', 'Egor', 'automated-testing');")) {
//
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCheckingMyNameInTable))
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("first_name") == "Egor" &&
                resultSet.getString("second_name") == "Matveev") {
                    PreparedStatement preparedStatement1 = connection.prepareStatement(sqlInsertMyName);
                    preparedStatement1.execute();
                    preparedStatement1.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }

    }
}
