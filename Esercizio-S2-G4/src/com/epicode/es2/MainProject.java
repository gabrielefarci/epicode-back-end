package com.epicode.es2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {

	public static void main(String[] args) {
		
        Product product1 = new Product(1L, "Diapers", "Baby", 15.0);
        Product product2 = new Product(2L, "Baby Shampoo", "Baby", 10.0);
        Product product3 = new Product(3L, "Stroller", "Kids", 200.0);
        Product product4 = new Product(4L, "Pacifier", "Baby", 5.0);

        Customer customer = new Customer(1L, "John Doe", 1);

        Order order1 = new Order(1L, "Pending", LocalDate.now(), LocalDate.now(), List.of(product1, product2), customer);
        Order order2 = new Order(2L, "Delivered", LocalDate.now(), LocalDate.now(), List.of(product3), customer);
        Order order3 = new Order(3L, "Pending", LocalDate.now(), LocalDate.now(), List.of(product4), customer);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby")))
                .collect(Collectors.toList());

        for (Order order : filteredOrders) {
            System.out.println("Order ID: " + order.getId());
        }

	}

}
