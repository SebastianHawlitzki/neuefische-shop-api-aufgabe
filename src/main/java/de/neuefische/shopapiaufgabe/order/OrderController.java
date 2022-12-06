package de.neuefische.shopapiaufgabe.order;

import de.neuefische.shopapiaufgabe.OrderResponse;
import de.neuefische.shopapiaufgabe.shop.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final ShopService shopService;

    public OrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<OrderResponse> getOrders () {
        return shopService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById (@PathVariable int id) {
        return shopService.getOrderById(id);
    }

    @PostMapping("/{id}")
    public Order postOrder (@PathVariable int id, @RequestBody List<Integer> productIds) {
        return shopService.createOrder(id, productIds);
    }
}
