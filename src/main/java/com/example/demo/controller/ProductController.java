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
import java.util.List;

@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet {
    ICategoryService categoryService = new ICategoryServiceImpl();
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("productID");
        int idProduct = 1;
        if(id != null){
            idProduct = Integer.parseInt(id);
        }
        ProductModel product = productService.getProductByID(idProduct);
        req.setAttribute("product",product);
        RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
        rq.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
