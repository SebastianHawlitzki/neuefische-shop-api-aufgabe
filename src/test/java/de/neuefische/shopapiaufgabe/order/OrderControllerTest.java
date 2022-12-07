package de.neuefische.shopapiaufgabe.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getOrders() throws Exception {
        //Given

        String expectedJson = """ 
                [
                    {
                        "id": 1,
                        "products": [
                            {
                                "id": 1,
                                "name": "Bannane",
                                "price": 1.3
                            },
                            {
                                "id": 2,
                                "name": "Toalletenpapier",
                                "price": 5.0
                            }
                        ]
                    }
                ]
                """;

        String path = "/api/orders";

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    void getOrderById() throws Exception {
        //Given

        String expectedJson = """ 
                     {
                         "id": 1,
                         "productIds": [
                             1,
                             2
                         ]
                     }
                """;

        String path = "/api/orders/1";

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    void postOrder() throws Exception {
        //Given
        String requestBody = """
             [1, 2]
                """;

        String expectedJson = """ 
                 {
                         "id": 1,
                         "productIds": [
                             1,
                             2
                         ]
                     }
                """;

        String path = "/api/orders/1";

        // When & Then
        mvc.perform(MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

}