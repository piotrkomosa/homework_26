import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionDao {


    private Scanner scanner;


    public void add (Transaction transaction) throws SQLException {
        PreparedStatement preparedStatement =null;
        Connection connection = connect();
        String sql = "INSERT INTO wydatki( date ,description , amount, type) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1,transaction.getDate());
        preparedStatement.setString(2 ,transaction.getDescription());
        preparedStatement.setInt(3, transaction.getAmount());
        preparedStatement.setBoolean(4, transaction.getType());
        preparedStatement.executeUpdate();

        closeConnection(connection);
    }

    public void modify(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transaction SET date = ? , description = ?, amount = ?, type = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,transaction.getDate());
            preparedStatement.setString(2 ,transaction.getDescription());
            preparedStatement.setInt(3, transaction.getAmount());
            preparedStatement.setBoolean(4, transaction.getType());
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }


    public void delete(int id) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM wydatki WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas usuwaniaz bazy: " + e.getMessage());
        }

        closeConnection(connection);
    }

    public void showAll(boolean type){
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM wydatki WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1,type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas usuwaniaz bazy: " + e.getMessage());
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/homework?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
  }
