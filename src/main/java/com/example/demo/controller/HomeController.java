package com.example.demo.controller;

import com.example.demo.Services.IProductService;
import com.example.demo.Services.Impl.ProductServiceImpl;
import com.example.demo.models.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel topProduct = productService.getBestProduct();
        req.setAttribute("topProduct",topProduct);
        List<ProductModel> top4newProduct = productService.get4NewProduct();
        req.setAttribute("top4NewProduct",top4newProduct);
        List<ProductModel> top4TopProduct = productService.get4TopProduct();
        req.setAttribute("top4TopProduct",top4TopProduct);
        RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
