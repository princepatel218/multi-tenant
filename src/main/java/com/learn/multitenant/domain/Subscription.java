package com.learn.multitenant.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID tenantId;
    private Long subscriptionPlanId;
    private Boolean isActive;
    private Timestamp validFrom;
    private Timestamp validUntil;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;

}
