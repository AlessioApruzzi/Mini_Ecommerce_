package org.tree.javacourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@Getter
@Setter@ToString
public class Product {

    private int id;
    private String name;
    private String description;
    private int aveilableNumber;
    private double price;

    public static Product fromResultSet(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("aveilableQuantity"),
                rs.getDouble("price"));
    }

}
