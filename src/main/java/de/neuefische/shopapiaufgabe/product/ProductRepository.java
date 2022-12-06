package de.neuefische.shopapiaufgabe.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> products = new ArrayList<>(
        List.of(
            new Product(1, "Bannane", 1.3),
            new Product(2, "Toalletenpapier", 5)
        )
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        Product product = null;

        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }

        return product;
    }
}
