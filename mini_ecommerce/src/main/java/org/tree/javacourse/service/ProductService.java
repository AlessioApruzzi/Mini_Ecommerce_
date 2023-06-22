package org.tree.javacourse.service;

import org.tree.javacourse.dao.Dao;
import org.tree.javacourse.dao.ProductDaoImpl;
import org.tree.javacourse.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductService {

    Dao daoProduct;

    public ProductService(){
        daoProduct = new ProductDaoImpl();
    }

    public boolean insert(Product u) throws SQLException {
        return daoProduct.insert(u);
    }

    public boolean update(Product u) throws SQLException {
        return daoProduct.update(u);
    }

    public boolean delete(int id) throws SQLException {
        return daoProduct.delete(id);
    }


    public Optional<Product> get(int id) throws SQLException {
        return daoProduct.get(id);
    }

    public List<Product> getAll() throws SQLException {
        return daoProduct.getAll();
    }
}
