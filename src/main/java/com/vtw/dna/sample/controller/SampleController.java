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

/**
* @package : com.vtw.dna.sample.controller
* @name : SampleController.java
* @date : 2022-06-02
* @author : Seungmin.bang
* @version : 1.0.0
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
                .withHeader("id", id)
                .to(direct("sample")).send();

        // 라우트 동작 중 에러가 발생했다면 에러를 출력
        Exception exception = exchange.getException();
        if (exception != null) {
            System.out.println(exception);
        }

        // Camel exchange의 body의 값을 획득하여 저장
        String text = exchange.getMessage().getBody(String.class);

        return text;
    }


}
