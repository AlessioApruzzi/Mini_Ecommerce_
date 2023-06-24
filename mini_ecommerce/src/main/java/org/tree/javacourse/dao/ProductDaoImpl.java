package org.tree.javacourse.dao;

import org.tree.javacourse.model.Products;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements Dao{

    public boolean insert(Products u) throws SQLException {
        return false;
    }

    public boolean update(Products u) throws SQLException {
        return false;
    }

    public boolean delete(int id) throws SQLException {
        return false;
    }

    public Optional<Products> get(int id) throws SQLException {
        return Optional.empty();
    }

    public List<Products> getAll() throws SQLException {
        return null;
    }
}
