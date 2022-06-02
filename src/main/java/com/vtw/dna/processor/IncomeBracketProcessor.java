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

/**
* @package : com.vtw.dna.processor
* @name : IncomeBracketProcessor.java
* @date : 2022-06-02
* @author : Seungmin.bang
* @version : 1.0.0
* @modifyed : 연봉정보를 이용하여 소득분위를 도출하는 Processor
**/
@Component
public class IncomeBracketProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // Camel exchange의 헤더값 중 person의 값을 획득하여 저장
        Map person = exchange.getMessage().getHeader("person", Map.class);

        int incomeBracket = 0;
        // 연봉 값을 획득하여 저장
        int salary = (int) person.get("salary");

        // 연봉 값에 따라 소득분위 값 도출
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

        // Camel exchange의 header에 소득분위 값을 저장
        exchange.getMessage().setHeader("incomeBracket", incomeBracket);
    }
}
