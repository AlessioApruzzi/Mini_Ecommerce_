package org.tree.javacourse.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.tree.javacourse.model.Product;

public interface Dao {
    boolean insert(Product u) throws SQLException;

    boolean update(Product u) throws SQLException;

    boolean delete(int id) throws SQLException;

    Optional<Product> get(int id) throws SQLException;

    List<Product> getAll() throws SQLException;
}
