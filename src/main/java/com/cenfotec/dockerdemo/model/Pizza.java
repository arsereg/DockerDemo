package com.cenfotec.dockerdemo.model;

import com.cenfotec.dockerdemo.enums.PizzaFlavor;
import com.cenfotec.dockerdemo.enums.PizzaSize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    PizzaSize pizzaSize;
    PizzaFlavor pizzaFlavor;
}
