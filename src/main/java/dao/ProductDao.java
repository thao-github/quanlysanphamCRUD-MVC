package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static Connection connection = ConnectMySql.getConnection();

    public static List<Product> getAllProduct() {
        String sqlGetAll = "SELECT * FROM product";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAll);

            ArrayList<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                String image = resultSet.getString("image");

                productList.add(new Product(id, name, idCategory, price, description, producer, image));

            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveProduct(Product product) {
        String saveSQL = "INSERT INTO product VALUES (?,?,?,?,?,?,?)";

        try {
            //connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQL);

            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getProducer());
            preparedStatement.setString(6, product.getImage());
            preparedStatement.setInt(7, product.getIdCategory());

            preparedStatement.execute();
            //connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editProduct(int id, Product product) {
        String updateSQL = "UPDATE product SET name=?, idCategory=?, price=?, description=?, producer=?, image=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getIdCategory());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getProducer());
            preparedStatement.setString(6, product.getImage());
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int id) {
        String deleteSQL = "DELETE from product where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Product> searchProduct(String searchName) {
        String searchSQL = "SELECT * FROM product WHERE name LIKE ?";
        ArrayList<Product> searchList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(searchSQL);
            preparedStatement.setString(1, "%" + searchName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                String image = resultSet.getString("image");

                searchList.add(new Product(id, name, idCategory, price, description, producer, image));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchList;
    }
}