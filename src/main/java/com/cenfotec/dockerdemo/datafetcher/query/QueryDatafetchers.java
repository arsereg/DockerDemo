package com.cenfotec.dockerdemo.datafetcher.query;

import com.cenfotec.dockerdemo.enums.PizzaFlavor;
import com.cenfotec.dockerdemo.enums.PizzaSize;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.Arrays;
import java.util.List;

@DgsComponent
public class QueryDatafetchers {


    @DgsQuery(field = "flavors")
    public List<String> flavors(){
        return Arrays.stream(PizzaFlavor.values()).map(PizzaFlavor::getValue).toList();
    }

    @DgsQuery(field = "sizes")
    public List<String> sizes(){
        return Arrays.stream(PizzaSize.values()).map(PizzaSize::getValue).toList();
    }

}
