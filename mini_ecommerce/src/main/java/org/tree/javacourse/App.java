package org.tree.javacourse;

import org.tree.javacourse.controller.ProductController;
import org.tree.javacourse.service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ProductService productService = ProductService.getInstance();

        ProductController productController = new ProductController();
        productController.startServices(productService);
    }
}
