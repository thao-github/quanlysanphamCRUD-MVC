package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    int findIndexById(int id);

    void editProduct(int index, Product product);

    void deleteProduct(int index);

    List<Product> searchProduct(String name);
}
