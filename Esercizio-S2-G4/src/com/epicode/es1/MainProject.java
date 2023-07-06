package com.epicode.es1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {

	public static void main(String[] args) {
		
        Product product1 = new Product(1L, "Book 1", "Books", 150.0);
        Product product2 = new Product(2L, "Book 2", "Books", 80.0);
        Product product3 = new Product(3L, "Book 3", "Books", 200.0);
        Product product4 = new Product(4L, "Laptop", "Electronics", 1200.0);

        Customer customer = new Customer(1L, "John Doe", 1);

        Order order = new Order(1L, "Pending", LocalDate.now(), LocalDate.now(), List.of(product1, product2, product3, product4), customer);

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        List<Product> filteredProducts = orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100.0)
                .collect(Collectors.toList());

        for (Product product : filteredProducts) {
            System.out.println(product.getName());
        }

	}

}
