package com.agendapro.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "STATISTICS")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Long count;
}
