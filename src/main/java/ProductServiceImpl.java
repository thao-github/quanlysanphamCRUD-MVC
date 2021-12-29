import dao.ProductDao;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static List<Product> productList = ProductDao.getAllProduct();

//    static{
//        productList.add(new model.Product(1, "Miss Dior", 3000, "Miss Dior", "Dior", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSff3iuXWf9GesUtarFom7bS2ndjJSZJ_CN_A&usqp=CAU" ));
//        productList.add(new model.Product(2, "Chanel", 4000, "Chanel", "Chanel", "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTRsxFDzAyRDLsC1HmqmyHIiVHbMA30t298t0JJBqtBKIKXBxw259Malqgczz4AEDCfzX676wnKQdlZ&usqp=CAc" ));
//        productList.add(new model.Product(3, "Chloe", 5000, "Chloe", "Chloe", "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQL9ldcDOp3qjkCL_86GTXtGEk8ZuLTKyJe9j8oin9krhZA7s56msJkbU2iWlogDx8J8vCApmYwjA&usqp=CAc" ));
//    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
        ProductDao.saveProduct(product);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void editProduct(int index, Product product) {
        ProductDao.editProduct(productList.get(index).getId(), product);
        productList = ProductDao.getAllProduct();
    }

    @Override
    public void deleteProduct(int id) {
        ProductDao.deleteProduct(productList.get(id).getId());
        productList = ProductDao.getAllProduct();
    }

    @Override
    public List<Product> searchProduct(String name) {
        return ProductDao.searchProduct(name);
    }
}
