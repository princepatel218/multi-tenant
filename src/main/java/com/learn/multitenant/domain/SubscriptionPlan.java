package com.learn.multitenant.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subscription_plans")
@Data
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
