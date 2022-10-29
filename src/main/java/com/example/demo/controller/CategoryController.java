package com.example.demo.controller;

import com.example.demo.Services.ICategoryService;
import com.example.demo.Services.IProductService;
import com.example.demo.Services.Impl.ICategoryServiceImpl;
import com.example.demo.Services.Impl.ProductServiceImpl;
import com.example.demo.models.CategoryModel;
import com.example.demo.models.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {
    ICategoryService categoryService = new ICategoryServiceImpl();
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryModel> categoryModels = categoryService.findAll();
        String id = req.getParameter("id");
        int idCate = -1;
        if(id == null){
            idCate = categoryModels.get(0).getCateId();
        }
        else {
            idCate = Integer.parseInt(id);
        }
        List<ProductModel> productModelList = productService.getProductByCategory(idCate);
        ProductModel lastProduct = productService.getLastProductByCategory(idCate);
        req.setAttribute("lastProduct",lastProduct);
        req.setAttribute("productList",productModelList);
        req.setAttribute("categoryList",categoryModels);
        RequestDispatcher rq = req.getRequestDispatcher("/views/category.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
