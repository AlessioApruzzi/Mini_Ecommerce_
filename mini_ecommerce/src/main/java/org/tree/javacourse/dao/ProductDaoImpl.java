package org.tree.javacourse.dao;

import org.tree.javacourse.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements Dao{

    public boolean insert(Product u) throws SQLException {
        return false;
    }


    public boolean update(Product u) throws SQLException {
        return false;
    }


    public boolean delete(int id) throws SQLException {
        return false;
    }


    public Optional<Product> get(int id) throws SQLException {
        return Optional.empty();
    }


    public List<Product> getAll() throws SQLException {
        return null;
    }
}
