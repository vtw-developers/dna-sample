package com.vtw.dna.sample.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.spi.Resource;
import org.apache.camel.spi.RoutesLoader;
import org.apache.camel.support.ResourceHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.direct;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    private final CamelContext camelContext;
    private final FluentProducerTemplate producerTemplate;

    @GetMapping
    public String sample(@RequestParam("id") String id) {
        Exchange exchange = producerTemplate.withBody("text")
                .withHeader("id", id)
                .to(direct("sample")).send();

        Exception exception = exchange.getException();
        if (exception != null) {
        }

        String text = exchange.getMessage().getBody(String.class);
        return text;
    }
}
