package com.learn.multitenant.domain;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "features")
@Data
@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
