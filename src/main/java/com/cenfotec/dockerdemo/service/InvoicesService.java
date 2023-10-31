package com.cenfotec.dockerdemo.service;

import com.cenfotec.dockerdemo.model.Invoice;
import com.cenfotec.dockerdemo.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoicesService {

    public Invoice calculateInvoice(List<Pizza> pizzas){
        double subTotal = 0;
        double total = 0;
        double tax = 0;

        for (Pizza pizza : pizzas) {
            subTotal += pizza.getPizzaSize().getPriceModifier() * pizza.getPizzaFlavor().getPrice();
        }

        tax = subTotal * 0.13;
        total = subTotal + tax;

        return new Invoice(total, tax, subTotal, pizzas);


    }

}
