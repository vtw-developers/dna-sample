package com.vtw.dna.processor;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
* @package : com.vtw.dna.processor
* @name : ResultGenerateProcessor.java
* @date : 2022-06-02
* @author : Seungmin.bang
* @version : 1.0.0
* @modifyed : 입력받은 id로 검색된 Person 정보와 대상지원금 정보를 합쳐 결과값을 생성하는 Processor
**/
@Component
public class ResultGenerateProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // Camel exchange의 헤더값 중 person의 값을 획득하여 저장
        Map person = exchange.getMessage().getHeader("person", Map.class);
        // Camel exchange의 헤더값 중 payment의 값을 획득하여 저장
        String payment = exchange.getMessage().getHeader("payment", String.class);

        Map result = new HashMap();

        // person값과 payment값을 Map에 담음
        result.put("person", person);
        result.put("payment", payment);

        // Camel exchange의 body에 Map을 저장
        exchange.getMessage().setBody(result);
    }
}
