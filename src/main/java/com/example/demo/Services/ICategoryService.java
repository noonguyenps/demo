package com.example.demo.Services;

import com.example.demo.models.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    void edit(CategoryModel category);
    void delete(int id);
    void create(CategoryModel categoryModel);
    CategoryModel get(int id);

}
