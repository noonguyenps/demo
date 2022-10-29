package com.example.demo.controller.admin.category;

import com.example.demo.Services.ICategoryService;
import com.example.demo.Services.Impl.ICategoryServiceImpl;
import com.example.demo.models.CategoryModel;
import com.example.demo.utils.Constant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
    ICategoryService cateService = new ICategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/views/admin/add-category.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        CategoryModel category = new CategoryModel();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            List<FileItem> items = null;
            items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("name")) {
                    category.setCateName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("status")) {
                    category.setStatus(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("icon")) {
                    String originalFileName = item.getName();
                    int index = originalFileName.lastIndexOf(".");
                    String ext = originalFileName.substring(index + 1);
                    String fileName = System.currentTimeMillis() + "." + ext;
                    File file = new File(Constant.DIR + "/category/" + fileName);
                    item.write(file);
                    category.setImages("category/"+fileName);
                }
            }
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
        cateService.create(category);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}


