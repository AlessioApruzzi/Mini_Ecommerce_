package org.tree.javacourse.service;

import org.tree.javacourse.dao.Dao;
import org.tree.javacourse.dao.ProductDaoImpl;
import org.tree.javacourse.dao.ProductDaoSql;
import org.tree.javacourse.model.Products;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductService {

    ProductDaoSql daoProduct;

    public ProductService(){
        daoProduct = new ProductDaoSql();
    }

    public boolean insert(Products u) throws SQLException {
        return daoProduct.insert(u);
    }

    public boolean update(Products u) throws SQLException {
        return daoProduct.update(u);
    }

    public boolean delete(int id) throws SQLException {
        return daoProduct.delete(id);
    }


    public Optional<Products> get(int id) throws SQLException {
        return daoProduct.get(id);
    }

    public List<Products> getAll() throws SQLException {
        return daoProduct.getAll();
    }
}
