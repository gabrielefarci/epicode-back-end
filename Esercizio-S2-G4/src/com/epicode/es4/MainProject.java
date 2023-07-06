package com.epicode.es4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {

	public static void main(String[] args) {
		
        Product product1 = new Product(1L, "Shirt", "Clothing", 50.0);
        Product product2 = new Product(2L, "Pants", "Clothing", 80.0);
        Product product3 = new Product(3L, "Shoes", "Footwear", 100.0);
        Product product4 = new Product(4L, "Hat", "Accessories", 30.0);

        Customer customer1 = new Customer(1L, "Mario Rossi", 1);
        Customer customer2 = new Customer(2L, "Giorgia Bianchi", 2);
        Customer customer3 = new Customer(3L, "Marco Neri", 2);

        Order order1 = new Order(1L, "Completed", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 18), List.of(product1, product2), customer1);
        Order order2 = new Order(2L, "Completed", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 8), List.of(product3), customer2);
        Order order3 = new Order(3L, "Completed", LocalDate.of(2021, 4, 2), LocalDate.of(2021, 4, 6), List.of(product4), customer3);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Product> orderedProducts = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 && isWithinRange(order.getOrderDate(), startDate, endDate))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());

        for (Product product : orderedProducts) {
            System.out.println(product.getName());
        }
    }

    private static boolean isWithinRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

}
