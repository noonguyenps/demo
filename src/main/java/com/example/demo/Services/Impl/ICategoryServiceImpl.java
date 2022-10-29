package com.example.demo.Services.Impl;
import com.example.demo.DAO.ICategoryDao;
import com.example.demo.DAO.Impl.CategoryImpl;
import com.example.demo.Services.ICategoryService;
import com.example.demo.models.CategoryModel;

import java.util.List;

public class ICategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new CategoryImpl();
    @Override
    public List<CategoryModel> findAll() {
        return  categoryDao.findAll();
    }

    @Override
    public void edit(CategoryModel category) {
        categoryDao.edit(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public void create(CategoryModel categoryModel) {
        categoryDao.create(categoryModel);
    }

    @Override
    public CategoryModel get(int id) {
        return categoryDao.get(id);
    }
}
