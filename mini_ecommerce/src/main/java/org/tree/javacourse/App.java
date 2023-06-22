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

        System.out.println( "Hello World!" );
        //TODO: Implementare come Singleton
        ProductService productService = new ProductService();

        ProductController productController = new ProductController();
        productController.startServices(productService);
    }
}
