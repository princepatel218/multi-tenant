package com.learn.multitenant.domain;

import com.learn.multitenant.domain.compositekey.SubscriptionPlanFeatureKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "subscription_plan_features")
@Data
@IdClass(SubscriptionPlanFeatureKey.class)
public class SubscriptionPlanFeature {
    @Id
    private Long subscriptionId;
    @Id
    private Long featureId;
    private Long defaultQuota;
}
