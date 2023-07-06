package com.epicode.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {

	public static void main(String[] args) {
		
        Product product1 = new Product(1L, "Shirt", "Boys", 50.0);
        Product product2 = new Product(2L, "Pants", "Boys", 80.0);
        Product product3 = new Product(3L, "Shoes", "Girls", 100.0);
        Product product4 = new Product(4L, "Hat", "Boys", 30.0);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
                    double discountedPrice = product.getPrice() * 0.9;
                    return new Product(product.getId(), product.getName(), product.getCategory(), discountedPrice);
                })
                .collect(Collectors.toList());

        for (Product product : filteredProducts) {
            System.out.println(product.getName() + " - Price: " + product.getPrice());
        }

	}

}
