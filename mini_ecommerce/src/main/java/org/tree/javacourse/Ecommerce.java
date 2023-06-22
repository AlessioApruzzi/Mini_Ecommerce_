
package org.tree.javacourse;

import org.tree.javacourse.dao.ProductDaoSql;
import org.tree.javacourse.model.Products;
import java.sql.SQLException;
import java.util.List;


public class Ecommerce {

    private ProductDaoSql productDaoSql = new ProductDaoSql();

    public void insertProduct(Products product) throws SQLException {

        productDaoSql.insert(product);
    }

    public void delete(int idProduct) throws SQLException {
        productDaoSql.delete(idProduct);
    }

    public List<Products> gettAll() throws SQLException {
        return productDaoSql.getAll();
    }

    public double buyProduct (int idProduct, int productQuantity){
    return 0;
    }



}

