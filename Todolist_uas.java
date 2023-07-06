
package todolist_uas;
import java.sql.*;
public class Todolist_uas {
private String url;
private String username;
private String password;

    public Todolist_uas(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void displayData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM todolist";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String todo = resultSet.getString("todo");
                String kategori = resultSet.getString("kategori");
                String tanggal_selesai = resultSet.getString("tanggal_selesai");
                String status = resultSet.getString("status");

                // Tampilkan data yang diambil
                System.out.println("ID : " + id);
                System.out.println("todo : " + todo);
                System.out.println("kategori : " + kategori);
                System.out.println("tanggal_selesai : " + tanggal_selesai);
                System.out.println("status : " + status);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }

    public void createData(int id, String todo, String kategori, String tanggal_selesai, String status) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO todolist (id, todo, kategori, tanggal_selesai, status) VALUES (" + id + ", '"
                    + todo + "', '" + kategori + "', '" + tanggal_selesai + "', '"
                    + status + "')";
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }

    public void updateData(int id, String newTodo, String newKategori, String newTanggal_selesai, String newStatus) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "UPDATE todolist SET todo = '" + newTodo + "', kategori = '"
                    + newKategori + "', tanggal_selesai = '" + newTanggal_selesai + "', status = '"
                    + newStatus + "' WHERE id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }

    public void deleteData(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM todolist WHERE id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }
}