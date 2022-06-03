package com.vtw.dna.sample.controller;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.direct;

/**
 * @author : Seungmin.bang
 * @version : 1.0.0
 * @package : com.vtw.dna.sample.controller
 * @name : SampleController.java
 * @date : 2022-06-02
 * @modifyed : sample route를 실행시키기 위한 Controller
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/routes")
public class SampleController {

    private final FluentProducerTemplate producerTemplate;

    @GetMapping("/{id}")
    public String toDirect(@PathVariable String id) {
        // Camel exchange를 생성하여 body와 header에 주민등록번호를 셋팅하고 sample 라우트에 보냄
        Exchange exchange = producerTemplate
                .withBody(id)
                .withHeader("id", id)
                .to(direct("sample")).send();

        // 라우트 동작 중 에러가 발생했다면 에러를 출력
        Exception exception = exchange.getException();
        if (exception != null) {
            System.out.println(exception);
            return exception.toString();
        }

        // Camel exchange의 body의 값을 획득하여 저장
        String text = exchange.getMessage().getBody(String.class);

        return text;
    }


}
