package com.tienda.integration;

import com.tienda.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Order sampleOrder() {
        Order o = new Order();
        o.setCustomerName("María");
        o.setCustomerEmail("maria@example.com");
        o.setProductDescription("Producto Integración");
        o.setQuantity(3);
        o.setTotalPrice(150.0);
        o.setStatus("PENDING");
        o.setCreatedAt(LocalDateTime.now());
        return o;
    }

    @Test
    void fullFlow_create_get_list_delete() {
        Order dto = sampleOrder();

        ResponseEntity<Order> created = restTemplate.postForEntity("/api/orders", dto, Order.class);
        assertThat(created.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Order createdBody = created.getBody();
        assertThat(createdBody).isNotNull();
        Long id = createdBody.getId();
        assertThat(id).isNotNull();

        ResponseEntity<Order> fetched = restTemplate.getForEntity("/api/orders/" + id, Order.class);
        assertThat(fetched.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(fetched.getBody()).isNotNull();

        ResponseEntity<List<Order>> list = restTemplate.exchange("/api/orders", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Order>>() {});
        assertThat(list.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(list.getBody()).isNotEmpty();

        ResponseEntity<Void> deleted = restTemplate.exchange("/api/orders/" + id, HttpMethod.DELETE, null, Void.class);
        assertThat(deleted.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        ResponseEntity<Order> notFound = restTemplate.getForEntity("/api/orders/" + id, Order.class);
        assertThat(notFound.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}

