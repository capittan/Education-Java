package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    String conStr;
    String user;
    String password;

    public CategoryService(String conStr, String user, String password) {
        this.conStr = conStr;
        this.user = user;
        this.password = password;
    }

    public void insert(CategoryInsert insert) {
        try (Connection connection = DriverManager.getConnection(conStr, user, password)) {
            String query = "INSERT INTO categories (name) VALUES (?)";
            PreparedStatement command = connection.prepareStatement(query);
            command.setString(1, insert.getName());
            command.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error of database:" + ex.getMessage());
        }
    }

    public void update(CategoryItem item) {
        try (Connection connection = DriverManager.getConnection(conStr, user, password)) {
            String query = "UPDATE categories SET name=(?) WHERE categories.id=(?)";
            PreparedStatement command = connection.prepareStatement(query);
            command.setString(1, item.getName());
            command.setInt(2, item.getId());
            command.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error of database:" + ex.getMessage());
        }
    }

    public CategoryItem getById(int id) {
        CategoryItem item = new CategoryItem();
        String sql = "SELECT * FROM categories WHERE id=(?)";
        try (Connection connection = DriverManager.getConnection(conStr, user, password)) {
            PreparedStatement command = connection.prepareStatement(sql);
            ResultSet resultSet = command.executeQuery();
            while (resultSet.next()) {
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
            }
        } catch (Exception ex) {
            System.out.println("Error of database:" + ex.getMessage());
        }
        return item;
    }

    public List<CategoryItem> getAll() {
        List<CategoryItem> list = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try (Connection connection = DriverManager.getConnection(conStr, user, password)) {
            PreparedStatement command = connection.prepareStatement(sql);
            ResultSet resultSet = command.executeQuery();
            while (resultSet.next()) {
                CategoryItem item = new CategoryItem();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                list.add(item);
            }
        } catch (Exception ex) {
            System.out.println("Error of database:" + ex.getMessage());
        }
        return list;
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(conStr, user, password)) {
            String query = "DELETE FROM categories WHERE id=(?)";
            PreparedStatement command = connection.prepareStatement(query);
            command.setInt(1, id);
            command.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error of database:" + ex.getMessage());
        }
    }
}
