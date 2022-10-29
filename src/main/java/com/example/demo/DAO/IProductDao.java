package com.example.demo.DAO;

import com.example.demo.models.ProductModel;

import java.util.List;

public interface IProductDao {
    List<ProductModel> findAll();
    ProductModel getTopProduct();
    List<ProductModel> get4NewProduct();
    List<ProductModel> get4TopProduct();
    List<ProductModel> getProductByCategoryId(int CateID);
    ProductModel getLastProductByCategoryId(int CateID);
    ProductModel getProductByID(int idProduct);
}
