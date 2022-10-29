package com.example.demo.Services;

import com.example.demo.models.ProductModel;

import java.util.List;

public interface IProductService {
    ProductModel getBestProduct();
    List<ProductModel> get4NewProduct();
    List<ProductModel> get4TopProduct();
    List<ProductModel> getProductByCategory(int cateID);
    ProductModel getLastProductByCategory(int cateID);
    ProductModel getProductByID(int productID);
}
