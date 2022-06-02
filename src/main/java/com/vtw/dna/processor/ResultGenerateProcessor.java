package com.vtw.dna.processor;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class ResultGenerateProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Map person = exchange.getMessage().getHeader("person", Map.class);
        String payment = exchange.getMessage().getHeader("payment", String.class);

        Map result = new HashMap();

        result.put("person", person);
        result.put("payment", payment);

        exchange.getMessage().setBody(result);
    }
}
