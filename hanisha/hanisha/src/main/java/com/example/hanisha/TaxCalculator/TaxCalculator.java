package com.example.hanisha.TaxCalculator;

import java.util.Arrays;
import java.util.List;

public class TaxCalculator {

    private static final double BASIC_TAX = 10.0;
    private static final double IMPORT_TAX = 5.0;
    private static final List<String> EXEMPT_CATEGORIES =
            Arrays.asList("book", "books", "chocolates", "chocolate", "pills", "pill");

    public Product parseProduct(String inputLine) {
        String[] parts = inputLine.split(" at ");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid input format: " + inputLine);

        String namePart = parts[0].trim();
        double price = Double.parseDouble(parts[1].trim());

        int firstSpace = namePart.indexOf(' ');
        int quantity = Integer.parseInt(namePart.substring(0, firstSpace));
        String itemName = namePart.substring(firstSpace + 1).trim();

        boolean imported = itemName.toLowerCase().contains("imported");
        boolean exempt = EXEMPT_CATEGORIES.stream()
                .anyMatch(category -> itemName.toLowerCase().contains(category));

        return new Product(quantity, itemName, price, imported, exempt);
    }

    public double calculateTax(Product product) {
        double taxRate = 0.0;
        if (!product.getExempt()){
            taxRate += BASIC_TAX;
        }
        if (product.getImported()){
            taxRate += IMPORT_TAX;
        }
        return roundUpToNearest((product.getPrice() * taxRate) / 100);
    }

    private double roundUpToNearest(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
