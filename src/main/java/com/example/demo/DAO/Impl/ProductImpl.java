package com.example.demo.DAO.Impl;

import com.example.demo.DAO.IProductDao;
import com.example.demo.DBConnection.ConnectJDBC;
import com.example.demo.models.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements IProductDao {
    @Override
    public List<ProductModel> findAll() {
        return null;
    }

    @Override
    public ProductModel getTopProduct() {
        ProductModel product = new ProductModel();
        String sql = "select * from( select max(wishlist) as wishlist from demo.product) as A, demo.product group by A.wishlist";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
                product.setImageLink(rs.getString("imageLink"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setSellerID(rs.getInt("SellerID"));
                product.setAmount(rs.getInt("Amount"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<ProductModel> get4NewProduct() {
        List<ProductModel> productModelList = new ArrayList<>();
        String sql = "SELECT * FROM demo.product\n" +
                "order by product.createDate\n" +
                "LIMIT 4;";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ProductModel product = new ProductModel();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
                product.setImageLink(rs.getString("imageLink"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setSellerID(rs.getInt("SellerID"));
                product.setAmount(rs.getInt("Amount"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                productModelList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productModelList;
    }

    @Override
    public List<ProductModel> get4TopProduct() {
        List<ProductModel> productModelList = new ArrayList<>();
        String sql = "SELECT * FROM demo.product\n" +
                "order by product.wishlist\n" +
                "LIMIT 4;";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ProductModel product = new ProductModel();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
                product.setImageLink(rs.getString("imageLink"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setSellerID(rs.getInt("SellerID"));
                product.setAmount(rs.getInt("Amount"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                productModelList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productModelList;
    }

    @Override
    public List<ProductModel> getProductByCategoryId(int cateID) {
        List<ProductModel> productModelList = new ArrayList<>();
        String sql = "SELECT * FROM demo.product WHERE product.CategoryID=?";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ProductModel product = new ProductModel();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
                product.setImageLink(rs.getString("imageLink"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setSellerID(rs.getInt("SellerID"));
                product.setAmount(rs.getInt("Amount"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                productModelList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productModelList;
    }

    @Override
    public ProductModel getLastProductByCategoryId(int cateID) {
        ProductModel product = new ProductModel();
        String sql = "SELECT * FROM demo.product WHERE product.CategoryID=? ORDER BY product.createDate LIMIT 1";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
                product.setImageLink(rs.getString("imageLink"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setSellerID(rs.getInt("SellerID"));
                product.setAmount(rs.getInt("Amount"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public ProductModel getProductByID(int idProduct) {
        ProductModel product = new ProductModel();
        String sql = "SELECT * FROM demo.product WHERE product.ProductID=?";
        try{
            Connection connection = ConnectJDBC.getMySQLConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,idProduct);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
                product.setImageLink(rs.getString("imageLink"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setSellerID(rs.getInt("SellerID"));
                product.setAmount(rs.getInt("Amount"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

}
