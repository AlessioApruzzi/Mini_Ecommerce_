package org.tree.javacourse.dao;

import org.tree.javacourse.connection_handler.ConnectionHandler;
import org.tree.javacourse.model.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoSql extends ProductDaoImpl{


    public boolean insert(Products products) throws SQLException {
        String query = "INSERT INTO product (name,description,quantity,price) VALUES (?,?,?,?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, products.getName());
            ps.setString(2, products.getDescription());
            ps.setInt(3, products.getQuantity());
            ps.setDouble(4, products.getPrice());
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }


    public boolean update(Products products) throws SQLException {
        String query = "UPDATE product SET name = ?, description= ?, quantity=?,price=? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, products.getName());
            ps.setString(2, products.getDescription());
            ps.setInt(3, products.getQuantity());
            ps.setDouble(4, products.getPrice());
            ps.setInt(5, products.getId());
            int updatedCount = ps.executeUpdate();
            return updatedCount > 0;

        }
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM product WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setInt(1, id);
            int deletedCount = ps.executeUpdate();
            return deletedCount > 0;

        }
    }

    public Optional<Products> get(int id) throws SQLException {
        String query = "SELECT * FROM product WHERE id = ?;";

        Optional<Products> posto = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) posto = Optional.of(Products.fromResultSet(rs));

        }

        return posto;
    }


    public List<Products> getAll() throws SQLException {
        String query = "SELECT * FROM product";

        List<Products> products = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) products.add(Products.fromResultSet(rs));
        }

        return products;
    }

    public Products getProductById(int id) throws SQLException {
        String query = "SELECT * FROM product WHERE id="+id;

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return Products.fromResultSet(rs);
            }
        }
        return null;
    }


}
