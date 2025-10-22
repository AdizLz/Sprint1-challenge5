package com.tienda.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tienda.TiendaOnlineApplication;
import com.tienda.model.Order;
import com.tienda.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
@Import(TiendaOnlineApplication.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private final ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    private Order sampleOrder() {
        Order o = new Order();
        o.setId(1L);
        o.setCustomerName("Juan");
        o.setCustomerEmail("juan@example.com");
        o.setProductDescription("Producto A");
        o.setQuantity(2);
        o.setTotalPrice(100.0);
        o.setStatus("PENDING");
        o.setCreatedAt(LocalDateTime.now());
        return o;
    }

    @Test
    void createOrder_success_returns201() throws Exception {
        Order o = sampleOrder();
        Mockito.when(orderService.createOrder(any(Order.class))).thenReturn(o);

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(o)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("Juan"));
    }

    @Test
    void createOrder_validationFails_returns400() throws Exception {
        Order invalid = sampleOrder();
        invalid.setCustomerEmail("invalid-email"); // violates @Email

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(invalid)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllOrders_returnsList() throws Exception {
        Order o = sampleOrder();
        Mockito.when(orderService.getAllOrders()).thenReturn(List.of(o));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void getOrderById_notFound_returns404() throws Exception {
        Mockito.when(orderService.getOrderById(eq(99L))).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound());
    }
}
