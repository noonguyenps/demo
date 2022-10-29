package com.example.demo.DAO.Impl;

import com.example.demo.DAO.ICategoryDao;
import com.example.demo.DBConnection.ConnectJDBC;
import com.example.demo.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl extends ConnectJDBC implements ICategoryDao {
    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
        String sql = "Select * from Category";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                CategoryModel category = new CategoryModel();
                category.setCateId(rs.getInt("categoryId"));
                category.setCateName(rs.getString("categoryName"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));

                categoryModels.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categoryModels;
    }

    @Override
    public void create(CategoryModel categoryModel) {
        String sql = "INSERT INTO category(categoryName,images,status) VALUES (?,?,?)";
        try {
            Connection con = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryModel.getCateName());
            ps.setString(2, categoryModel.getImages());
            ps.setInt(3,categoryModel.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(CategoryModel category) {
        String sql = "UPDATE category SET categoryName = ?, images=?, status=? WHERE categoryId = ?";
        try {
            Connection con = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCateName());
            ps.setString(2, category.getImages());
            ps.setInt(3,category.getStatus());
            ps.setInt(4, category.getCateId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM category WHERE categoryId = ?";
        try {
            Connection con = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CategoryModel get(int id) {
        String sql = "SELECT * FROM category WHERE categoryId = ? ";
        try {
            Connection con = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCateId(rs.getInt("categoryId"));
                category.setCateName(rs.getString("categoryName"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
