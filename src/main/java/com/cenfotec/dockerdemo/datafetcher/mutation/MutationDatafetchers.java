package com.cenfotec.dockerdemo.datafetcher.mutation;

import com.cenfotec.dockerdemo.enums.PizzaFlavor;
import com.cenfotec.dockerdemo.enums.PizzaSize;
import com.cenfotec.dockerdemo.model.Invoice;
import com.cenfotec.dockerdemo.model.Pizza;
import com.cenfotec.dockerdemo.service.InvoicesService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class MutationDatafetchers {

    private final InvoicesService invoicesService;

    public MutationDatafetchers(InvoicesService invoicesService) {
        this.invoicesService = invoicesService;
    }

    @DgsMutation(field = "orderPizza")
    public Invoice flavors(@InputArgument("pizzas")List<Pizza> pizzas){
        return invoicesService.calculateInvoice(pizzas);
    }
}
