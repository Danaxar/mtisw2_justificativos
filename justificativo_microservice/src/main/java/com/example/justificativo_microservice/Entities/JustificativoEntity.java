package com.example.justificativo_microservice.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "justificativo")
@Data
public class JustificativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String fecha;
    private String rut;
}