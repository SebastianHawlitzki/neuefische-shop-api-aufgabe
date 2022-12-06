package de.neuefische.shopapiaufgabe;

import de.neuefische.shopapiaufgabe.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponse {
    private int id;
    private List<Product> products;
}
