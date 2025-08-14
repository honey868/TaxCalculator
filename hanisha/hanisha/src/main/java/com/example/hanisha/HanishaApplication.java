package com.example.hanisha;

import com.example.hanisha.TaxCalculator.Product;
import com.example.hanisha.TaxCalculator.Receipt;
import com.example.hanisha.TaxCalculator.TaxCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class HanishaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanishaApplication.class, args);
			Scanner sc = new Scanner(System.in);
			TaxCalculator calculator = new TaxCalculator();
			Receipt receipt = new Receipt();

			System.out.println("Enter items (empty line to finish):");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.trim().isEmpty()) break;
				Product product = calculator.parseProduct(line);
				receipt.addProduct(product);
			}
			receipt.printSummary();
		}
	}


