package org.tree.javacourse.service;

import org.tree.javacourse.connection_handler.ConnectionHandler;
import org.tree.javacourse.dao.ProductDaoSql;
import org.tree.javacourse.model.Products;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductDaoSql daoProduct;

    private static ProductService productServiceInstance;

    private ProductService(){
        daoProduct = new ProductDaoSql();
    }

    public static ProductService getInstance() {
        if (productServiceInstance == null)
            productServiceInstance = new ProductService();

        return productServiceInstance;
    }

    public boolean insert(Products u) throws SQLException {
        return daoProduct.insert(u);
    }

    public boolean update(Products u) throws SQLException {
        return daoProduct.update(u);
    }

    public boolean delete(int id) throws SQLException {
        return daoProduct.delete(id);
    }


    public Optional<Products> get(int id) throws SQLException {
        return daoProduct.get(id);
    }

    public List<Products> getAll() throws SQLException {
        return daoProduct.getAll();
    }



    public double buyProduct(int idProduct,int quantity) throws SQLException {
        Products productToBuy = daoProduct.getProductById(idProduct);
        int number;
        if (productToBuy.getQuantity()<quantity){
            System.out.println("You bought only " + productToBuy.getQuantity());
            number= productToBuy.getQuantity();
            productToBuy.setQuantity(0);

        } else {
            productToBuy.setQuantity(productToBuy.getQuantity()-quantity);
            number=quantity;
        }
        daoProduct.update(productToBuy);
        return productToBuy.getPrice()*number;
    }
}
