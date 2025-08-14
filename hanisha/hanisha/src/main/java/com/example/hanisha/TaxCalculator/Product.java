package com.example.hanisha.TaxCalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    Integer quantity;
    String name;
    Double price;
    Boolean imported;
    Boolean exempt;

}
