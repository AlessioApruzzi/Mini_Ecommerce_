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
public class Products {

    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public static Products fromResultSet(ResultSet rs) throws SQLException {
        return new Products(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("quantity"),
                rs.getDouble("price"));
    }

}
