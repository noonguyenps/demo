package com.example.demo.controller.admin.category;

import com.example.demo.utils.Constant;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/image") // ?fname=abc.png
public class DownloadFileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {
        String fileName = req.getParameter("fname");
        File file = new File(Constant.DIR + "/" + fileName);
        resp.setContentType("image/png");
        if (file.exists()) {
            IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
        }
    }
}
