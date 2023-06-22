package org.tree.javacourse.dao;

import connection_handler.ConnectionHandler;
import model.Posto;
import org.tree.javacourse.connection_handler.ConnectionHandler;
import org.tree.javacourse.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoSql extends ProductDaoImpl{


    public boolean insert(Product product) throws SQLException {
        String query = "INSERT INTO miniecommerce.product (name,description,aveilableNumber,price) VALUES (?,?,?,?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getAveilableNumber());
            ps.setDouble(4, product.getPrice());
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }


    public boolean update(Product product) throws SQLException {
        String query = "UPDATE miniecommerce.product SET name = ?, description= ?, aveilableNumner=?,price=? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getAveilableNumber());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getId());
            int updatedCount = ps.executeUpdate();
            return updatedCount > 0;

        }
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM teatro.posto WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setInt(1, id);
            int deletedCount = ps.executeUpdate();
            return deletedCount > 0;

        }
    }

    public Optional<Product> get(int id) throws SQLException {
        String query = "SELECT * FROM miniecommerce.product WHERE id = ?;";

        Optional<Product> posto = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) posto = Optional.of(Product.fromResultSet(rs));

        }

        return posto;
    }


    public List<Product> getAll() throws SQLException {
        String query = "SELECT * FROM miniecommerce.product;";

        List<Product> products = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) products.add(Product.fromResultSet(rs));
        }

        return products;
    }


    public int getPostoByFilaENumero(int fila, int numero) throws SQLException {
        String query = "SELECT * FROM teatro.posto WHERE posto.fila = '" + fila + "'"+ " And posto.numero = '" + numero + "'";
        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery())
        {
            rs.next();
            return rs.getInt("id_posto");
        }
    }
}
