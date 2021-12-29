package dao;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private static Connection connection = ConnectMySql.getConnection();

    public static List<Category> getAllCategory() {
        String sqlGetAll = "SELECT * FROM category";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAll);

            ArrayList<Category> categories = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("idCategory");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
