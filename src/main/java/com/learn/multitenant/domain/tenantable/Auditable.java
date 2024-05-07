package com.learn.multitenant.domain.tenantable;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

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