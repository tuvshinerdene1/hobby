package dao;

import model.Todo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    private final String URL = "jdbc:sqlite:todos.db";

    public TodoDAO() {
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS todos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "task TEXT NOT NULL," +
                    "completed BOOLEAN DEFAULT 0)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Todo> getAll() {
        List<Todo> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("Select * from todos")) {
            while (rs.next()) {
                list.add(new Todo(rs.getInt("id"), rs.getString("task"), rs.getBoolean("completed")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(String task) {
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO todos (task) VALUES (?)")) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String task, boolean completed){
        String sql = "UPDATE todos SET task = ?, completed = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, task);
                pstmt.setBoolean(2, completed);
                pstmt.setInt(3, id);
                pstmt.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }
    }

}
