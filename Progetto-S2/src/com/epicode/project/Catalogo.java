package com.epicode.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Catalogo {
	
	private List<ElementiCatalogo> items;

    public Catalogo() {
        items = new ArrayList<>();
    }
    
    public void addItem(ElementiCatalogo item) {
        items.add(item);
    }
	
	public boolean removeItem(String isbn) {
	    for (ElementiCatalogo item : items) {
	        if (item.getIsbn().equals(isbn)) {
	            items.remove(item);
	            return true;
	        }
	    }
	    return false;
	}
    
	public List<ElementiCatalogo> searchByPublicationYear(int year) {
	    List<ElementiCatalogo> matchingItems = new ArrayList<>();
	    for (ElementiCatalogo item : items) {
	        if (item instanceof Libri && item.getPublicationYear() == year) {
	            matchingItems.add(item);
	        } else if (item instanceof Riviste && item.getPublicationYear() == year) {
	            matchingItems.add(item);
	        }
	    }
	    return matchingItems;
	}

    public List<ElementiCatalogo> searchByAuthor(String author) {
        return items.stream()
                .filter(item -> item instanceof Libri)
                .filter(item -> ((Libri) item).getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
    
    public List<ElementiCatalogo> getItems() {
        return items;
    }
	
	public String getCatalogAsString() {
        StringBuilder catalogAsString = new StringBuilder();
        for (ElementiCatalogo item : items) {
            catalogAsString.append(item.toString()).append("\n");
        }
        return catalogAsString.toString();
    }
	
}
