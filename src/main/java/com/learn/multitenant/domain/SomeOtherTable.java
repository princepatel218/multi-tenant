package com.learn.multitenant.domain;

import com.learn.multitenant.domain.tenantable.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.TenantId;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "some_other_table")
public class SomeOtherTable extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @TenantId
    private UUID tenantId;
    private String name;
    private String value;
    @CreatedBy
    @Column(updatable = false)
    private Long createdBy;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdTimestamp;
    @LastModifiedBy
    private Long updatedBy;
    @UpdateTimestamp
    private Timestamp updatedTimestamp;
}
