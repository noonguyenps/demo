package com.example.demo.controller;

import com.example.demo.Services.ICategoryService;
import com.example.demo.Services.IProductService;
import com.example.demo.Services.Impl.ICategoryServiceImpl;
import com.example.demo.Services.Impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/contact"})
public class ContactController extends HttpServlet {
    ICategoryService categoryService = new ICategoryServiceImpl();
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("/views/contact.jsp");
        rq.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
