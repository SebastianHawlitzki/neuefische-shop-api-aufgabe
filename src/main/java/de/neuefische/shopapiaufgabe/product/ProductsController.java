package de.neuefische.shopapiaufgabe.product;

import de.neuefische.shopapiaufgabe.shop.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ShopService shopService;

    public ProductsController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Product> getProducts () {
        return shopService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById (@PathVariable int id) {
        return shopService.getProductById(id);
    }
}
