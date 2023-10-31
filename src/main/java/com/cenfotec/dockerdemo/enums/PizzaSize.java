package com.cenfotec.dockerdemo.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PizzaSize {
    SMALL("SMALL", 0.8),
    MEDIUM("MEDIUM", 1),
    LARGE("LARGE", 1.5),
    EXTRA_LARGE("EXTRA_LARGE", 2);

    private String value;
    private double priceModifier;

    PizzaSize(String value, double priceModifier) {
        this.value = value;
        this.priceModifier = priceModifier;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public double getPriceModifier() {
        return priceModifier;
    }


}
