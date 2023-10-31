package com.cenfotec.dockerdemo.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

public enum PizzaFlavor {
    MARGHERITA("MARGHERITA", 10_000),
    PEPPERONI("PEPPERONI", 13_000),
    FOUR_CHEESE("FOUR_CHEESE", 14_000),
    HAWAIIAN("HAWAIIAN", 12_500);

    private String value;
    private double price;

    PizzaFlavor(String value, double price) {
        this.value = value;
        this.price = price;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public double getPrice() {
        return price;
    }

}
