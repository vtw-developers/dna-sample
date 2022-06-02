package com.vtw.dna.sample.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.*;
import org.apache.camel.spi.Resource;
import org.apache.camel.spi.RoutesLoader;
import org.apache.camel.support.ResourceHelper;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.direct;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/routes")
public class SampleController {

    private final CamelContext camelContext;
    private final FluentProducerTemplate producerTemplate;

    @GetMapping("/{id}")
//    public String toDirect(@RequestParam("id") String id) {
    public String toDirect(@PathVariable String id) {

//        Route route = camelContext.getRoutes().stream().filter(e -> e.getRouteId().equals("sample")).findFirst().get();

        Exchange exchange = producerTemplate
                .withBody(id)
                .withHeader("id", id)
                .to(direct("sample")).send();

        Exception exception = exchange.getException();
        if (exception != null) {
            System.out.println(exception);
        }

        String text = exchange.getMessage().getBody(String.class);

        return text;
    }


}
