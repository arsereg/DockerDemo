package com.cenfotec.dockerdemo.service;

import com.cenfotec.dockerdemo.enums.PizzaFlavor;
import com.cenfotec.dockerdemo.enums.PizzaSize;
import com.cenfotec.dockerdemo.model.Pizza;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoicesServiceTest {

    @Test
    void calculateInvoice_single_pizza() {
        InvoicesService invoicesService = new InvoicesService();
        List<Pizza> pizzas = List.of(
                new Pizza(PizzaSize.LARGE, PizzaFlavor.MARGHERITA) // 15_000
        );

        double expectedTax = 1950.0;
        double actualTax = invoicesService.calculateInvoice(pizzas).getTax();

        double expectedValue = 16_950.0;
        double actualValue = invoicesService.calculateInvoice(pizzas).getTotal();

        double expectedSubTotal = 15_000.0;
        double actualSubTotal = invoicesService.calculateInvoice(pizzas).getSubTotal();


        assertEquals(expectedTax, actualTax);
        assertEquals(expectedValue, actualValue);
        assertEquals(expectedSubTotal, actualSubTotal);
    }

    @Test
    void calculateInvoice_three_pizzas() {
        InvoicesService invoicesService = new InvoicesService();
        List<Pizza> pizzas = List.of(
                new Pizza(PizzaSize.LARGE, PizzaFlavor.MARGHERITA), // 15_000
                new Pizza(PizzaSize.SMALL, PizzaFlavor.FOUR_CHEESE), // 11_200
                new Pizza(PizzaSize.MEDIUM, PizzaFlavor.HAWAIIAN) // 12_500

        );

        double expectedTax = 5031.0;
        double actualTax = invoicesService.calculateInvoice(pizzas).getTax();

        double expectedValue = 43_731.0;
        double actualValue = invoicesService.calculateInvoice(pizzas).getTotal();

        double expectedSubTotal = 38700.0;
        double actualSubTotal = invoicesService.calculateInvoice(pizzas).getSubTotal();

        assertEquals(expectedTax, actualTax);
        assertTrue(expectedValue == actualValue);
    }
}