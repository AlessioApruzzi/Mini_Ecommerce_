package org.tree.javacourse.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.tree.javacourse.model.Products;

public interface Dao {
    boolean insert(Products u) throws SQLException;

    boolean update(Products u) throws SQLException;

    boolean delete(int id) throws SQLException;

    Optional<Products> get(int id) throws SQLException;

    List<Products> getAll() throws SQLException;
}
