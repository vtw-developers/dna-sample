package com.vtw.dna.processor;

import com.vtw.dna.person.Person;
import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class IncomeBracketProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Map person = exchange.getMessage().getHeader("person", Map.class);

        int incomeBracket = 0;
        int salary = (int) person.get("salary");

        if (salary >= 100000) {
            incomeBracket = 1;
        } else if (salary >= 9000) {
            incomeBracket = 1;
        } else if (salary >= 8000) {
            incomeBracket = 2;
        } else if (salary >= 7000) {
            incomeBracket = 3;
        } else if (salary >= 6000) {
            incomeBracket = 4;
        } else if (salary >= 5000) {
            incomeBracket = 5;
        } else if (salary >= 4000) {
            incomeBracket = 6;
        } else if (salary >= 3000) {
            incomeBracket = 7;
        } else if (salary >= 2000) {
            incomeBracket = 8;
        } else if (salary >= 1000) {
            incomeBracket = 9;
        } else if (salary >= 0) {
            incomeBracket = 10;
        }

        exchange.getMessage().setHeader("incomeBracket", incomeBracket);
    }
}
