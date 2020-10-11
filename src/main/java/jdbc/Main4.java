package jdbc;

import java.sql.*;


public class Main4 {

    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "a1bfi5cn";
        final String url = "jdbc:postgresql://localhost:5432/avecoder";
        final String table = "student";
        final String firstName = "Egor";
        final String secondName = "Matveev";


        String sqlCheckingMyNameInTable = "SELECT * FROM student WHERE second_name = (?) AND first_name = (?);";
        String sqlInsertMyName = "INSERT INTO student (second_name, first_name, patronymic) VALUES ((?), (?), 'automation testing');";

        final Connection connection = DriverManager.getConnection(url, user, password);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCheckingMyNameInTable)) {
//            preparedStatement.setString(1, table);
            preparedStatement.setString(1, secondName);
            preparedStatement.setString(2, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (!resultSet.next()) {
                PreparedStatement preparedStatement1 = connection.prepareStatement(sqlInsertMyName);
//                preparedStatement1.setString(1, table);
                preparedStatement1.setString(1, secondName);
                preparedStatement1.setString(2, firstName);
                preparedStatement1.execute();
                preparedStatement1.close();
            } else {
                System.out.println("This student is already in the table");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}

