package com.agendapro.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacía")
    private String name;
    @NotBlank(message = "La categoria no puede estar vacía")
    private String category;
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser un número positivo o cero")
    @Column(name = "price", nullable = false)
    private Double price;
}
