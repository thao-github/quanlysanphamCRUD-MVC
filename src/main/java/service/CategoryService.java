package service;

import dao.CategoryDao;
import model.Category;

import java.util.List;

public class CategoryService {
    public static List<Category> categories = CategoryDao.getAllCategory();
}
