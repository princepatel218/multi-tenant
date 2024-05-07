package com.learn.multitenant.domain;

import com.learn.multitenant.domain.tenantable.Tenantable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "some_table")
public class SomeTable extends Tenantable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID tenantId;
    private String name;
    private String value;
}
