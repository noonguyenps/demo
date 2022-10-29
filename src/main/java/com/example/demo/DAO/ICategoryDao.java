package com.example.demo.DAO;
import com.example.demo.models.CategoryModel;

import java.util.List;

public interface ICategoryDao {
    List<CategoryModel> findAll();
    void create(CategoryModel categoryModel);
    void edit(CategoryModel category);
    void delete(int id);
    CategoryModel get(int id);

}
