package com.example.demo.Services.Impl;

import com.example.demo.DAO.IProductDao;
import com.example.demo.DAO.Impl.ProductImpl;
import com.example.demo.Services.IProductService;
import com.example.demo.models.ProductModel;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductDao productDao = new ProductImpl();
    @Override
    public ProductModel getBestProduct() {
        return productDao.getTopProduct();
    }

    @Override
    public List<ProductModel> get4NewProduct() {
        return productDao.get4NewProduct();
    }

    @Override
    public List<ProductModel> get4TopProduct() {
        return productDao.get4TopProduct();
    }

    @Override
    public List<ProductModel> getProductByCategory(int cateID) {
        return productDao.getProductByCategoryId(cateID);
    }

    @Override
    public ProductModel getLastProductByCategory(int cateID) {
        return productDao.getLastProductByCategoryId(cateID);
    }

    @Override
    public ProductModel getProductByID(int productID) {
        return productDao.getProductByID(productID);
    }
}
