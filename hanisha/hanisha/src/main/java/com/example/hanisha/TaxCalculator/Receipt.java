package com.example.hanisha.TaxCalculator;

public class Receipt {
    private double totalTax = 0.0;
    private double total = 0.0;
    private final TaxCalculator calculator = new TaxCalculator();

    public void addProduct(Product product) {
        double tax = calculator.calculateTax(product);
        double totalPrice = product.getPrice() + tax;
        totalTax += tax;
        total += totalPrice;
        System.out.printf("%d %s: %.2f%n", product.getQuantity(), product.getName(), totalPrice);
    }

    public void printSummary() {
        System.out.printf("Sales Taxes: %.2f%n", totalTax);
        System.out.printf("Total: %.2f%n", total);
    }
}
