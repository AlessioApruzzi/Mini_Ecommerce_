package org.tree.javacourse.controller;

import com.google.gson.Gson;
import org.tree.javacourse.controller.response.HttpResponse;
import org.tree.javacourse.model.Products;
import org.tree.javacourse.service.ProductService;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;

public class ProductController {

    public void startServices(ProductService productService) {

        //heartbit
        get("/", (req, res) -> "System is working!");

        get("/user/all", (req, res) -> {
            res.type("application/json");

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(productService.getAll()));

            return new Gson().toJson(response);
        });

        post("/user", (req, res) -> {
            res.type("application/json");

            Products productsFromPostRequest = new Gson().fromJson(req.body(), Products.class);
            productService.insert(productsFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        put("/user", (req, res) -> {
            res.type("application/json");

            Products productsFromPostRequest = new Gson().fromJson(req.body(), Products.class);
            productService.update(productsFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        delete("/user/:id", (req, res) -> {
            res.type("application/json");

            String paramID = req.params("id");
            productService.delete(Integer.valueOf(paramID));

            return new Gson().toJson(new HttpResponse("200"));
        });
    }
}
