package org.tree.javacourse.controller;

import com.google.gson.Gson;
import org.tree.javacourse.controller.response.HttpResponse;
import org.tree.javacourse.model.Products;
import org.tree.javacourse.service.ProductService;

import static spark.Spark.*;

public class ProductController {

    public void startServices(ProductService productService) {

        //heartbit
        get("/", (req, res) -> "System is working!");

        get("/product/all", (req, res) -> {
            res.type("application/json");

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(productService.getAll()));

            return new Gson().toJson(response);
        });

        post("/product/create", (req, res) -> {
            res.type("application/json");

            Products productsFromPostRequest = new Gson().fromJson(req.body(), Products.class);

            productService.insert(productsFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        put("/product/update", (req, res) -> {
            res.type("application/json");

            Products productsFromPostRequest = new Gson().fromJson(req.body(), Products.class);
            productService.update(productsFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        delete("/product/delete/:id", (req, res) -> {
            res.type("application/json");

            String paramID = req.params("id");
            productService.delete(Integer.valueOf(paramID));

            return new Gson().toJson(new HttpResponse("200"));
        });


        put("/product/buy",(req, res) -> {
            res.type("application/json");
            Products productsFromPostRequest = new Gson().fromJson(req.body(), Products.class);

            double totalPrice = productService.buyProduct(productsFromPostRequest.getId(),productsFromPostRequest.getQuantity());
            return new Gson().toJson(new HttpResponse("200",
                    new Gson().toJsonTree(totalPrice)));
        });

    }
}
