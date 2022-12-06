package de.neuefische.shopapiaufgabe.shop;

import de.neuefische.shopapiaufgabe.OrderResponse;
import de.neuefische.shopapiaufgabe.order.Order;
import de.neuefische.shopapiaufgabe.order.OrderRepository;
import de.neuefische.shopapiaufgabe.product.Product;
import de.neuefische.shopapiaufgabe.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<OrderResponse> getOrders() {
        List<Order> orders = orderRepository.getOrders();
        List<OrderResponse> orderRespons = new ArrayList<>();
        for (Order o : orders) {
            List<Product> products = new ArrayList<>();
            for (int id : o.getProductIds()) {
                products.add(productRepository.getProductById(id));
            }
            orderRespons.add(new OrderResponse(o.getId(), products));
        }

        return orderRespons;
    }

    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    public Order createOrder(int id, List<Integer> productIds) {
        return orderRepository.createOrder(id, productIds);
    }
}
