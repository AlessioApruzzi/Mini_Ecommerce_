package org.tree.javacourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter@ToString
public class Product {

    private int id;
    private String name;
    private String description;
    private int aveilableNumber;
    private double price;

}
