package com.learn.multitenant.domain.compositekey;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubscriptionPlanFeatureKey implements Serializable {
    private Long subscriptionId;
    private Long featureId;
}
