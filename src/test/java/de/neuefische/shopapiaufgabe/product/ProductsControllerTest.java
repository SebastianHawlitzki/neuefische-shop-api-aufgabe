package de.neuefische.shopapiaufgabe.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ProductsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getProducts_getProductList() throws Exception {
        //Given

        String expectedJson = """ 
                [{"id":1,"name":"Bannane","price":1.3},{"id":2,"name":"Toalletenpapier","price":5.0}]
                """;

        String path = "/api/products";

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    void getProductById() throws Exception {
        //Given

        String expectedJson = """ 
                {
                    "id": 1,
                    "name": "Bannane",
                    "price": 1.3
                }
                """;

        String path = "/api/products/1";

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

}


