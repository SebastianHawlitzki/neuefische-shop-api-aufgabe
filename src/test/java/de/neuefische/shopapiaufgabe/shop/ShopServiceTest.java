package de.neuefische.shopapiaufgabe.shop;

import de.neuefische.shopapiaufgabe.order.Order;
import de.neuefische.shopapiaufgabe.order.OrderRepository;
import de.neuefische.shopapiaufgabe.order.OrderResponse;
import de.neuefische.shopapiaufgabe.product.Product;
import de.neuefische.shopapiaufgabe.product.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    @Test
    void getProducts() {
        //given
        List<Product> productList = new ArrayList<>(
                List.of(
                        new Product(1, "Ananas", 3.49),
                        new Product(2, "Banane", 1.99),
                        new Product(3, "Apple", 0.49)
                )
        );


        ProductRepository productRepo = mock(ProductRepository.class);
        when(productRepo.getProducts()).thenReturn(productList);

        //when
        ShopService shopService = new ShopService(productRepo, null);

        List<Product> actual = shopService.getProducts();

        //then
        assertEquals(productList, actual);
        verify(productRepo).getProducts();

    }
/*
    @Test
    void getOrdersAllOrderIfAllProductsExist() {
        //given

        List<Product> productList = new ArrayList<>(
                List.of(
                        new Product(1, "Ananas", 3.49)
                        )
        );

        List<OrderResponse> orderResponseList = new ArrayList<>(
                List.of(
                        new OrderResponse(21, productList)

                )
        );

        List<Order> orderList = new ArrayList<>(
                List.of(
                        new Order(21, List.of(1))
                )
        );

        OrderRepository orderRepo = mock(OrderRepository.class);
        when(orderRepo.getOrders()).thenReturn(orderList);

        ProductRepository productRepo = mock(ProductRepository.class);
        when(productRepo.getProductById())


        //when
        ShopService shopService = new ShopService(productRepo, orderRepo);
        List<OrderResponse> actual = shopService.getOrders();

        //then
        assertEquals( ?, actual);

    }


    @Test
    void getOrdersReturnsRemovesProductFromOrderIfProductDoesNotExistAnymore() {
        //given

        //when

        //then


    }
    */

}