package com.cenfotec.dockerdemo.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private double total;
    private double tax;
    private double subTotal;
    private List<Pizza> pizzas;


}
