package com.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Entidad que representa una orden en la tienda online.
 *
 * Contiene información del cliente, producto, cantidad, precio total,
 * estado y fecha de creación.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String customerName;

    @Column(nullable = false)
    @NotBlank(message = "El email del cliente no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    private String customerEmail;

    @Column(nullable = false)
    @NotBlank(message = "La descripción del producto no puede estar vacía")
    private String productDescription;

    @Column(nullable = false)
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer quantity;

    @Column(nullable = false)
    @NotNull(message = "El precio total es obligatorio")
    @PositiveOrZero(message = "El precio total debe ser 0 o mayor")
    private Double totalPrice;

    @Column(nullable = false)
    @NotBlank(message = "El estado no puede estar vacío")
    private String status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * Constructor por defecto. Inicializa createdAt y estado por defecto.
     */
    public Order() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters y Setters
    /**
     * Obtiene el identificador de la orden.
     * @return id de la orden
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la orden.
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return nombre del cliente
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Establece el nombre del cliente.
     * @param customerName nombre del cliente
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Obtiene el email del cliente.
     * @return email del cliente
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Establece el email del cliente.
     * @param customerEmail email del cliente
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Obtiene la descripción del producto.
     * @return descripción del producto
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Establece la descripción del producto.
     * @param productDescription descripción del producto
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Obtiene la cantidad solicitada.
     * @return cantidad
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Establece la cantidad solicitada.
     * @param quantity cantidad
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Obtiene el precio total de la orden.
     * @return precio total
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Establece el precio total de la orden.
     * @param totalPrice precio total
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Obtiene el estado de la orden.
     * @return estado
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el estado de la orden.
     * @param status estado
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtiene la fecha de creación de la orden.
     * @return fecha de creación
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Establece la fecha de creación de la orden.
     * @param createdAt fecha de creación
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}