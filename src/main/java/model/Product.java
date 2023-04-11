package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String category;
}
