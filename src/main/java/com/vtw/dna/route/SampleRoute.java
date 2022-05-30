package com.vtw.dna.route;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.spi.Resource;
import org.apache.camel.spi.RoutesLoader;
import org.apache.camel.support.ResourceHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;

@Slf4j
@Component
@AllArgsConstructor
public class SampleRoute {

    private final CamelContext camelContext;

    @PostConstruct
    public void startRoute() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\User\\Desktop\\sample.yaml"), "UTF-8"));

        String line = reader.readLine();
        StringBuffer sb = new StringBuffer();

        while (line != null) {
            sb.append(line).append("\n");
            line = reader.readLine();
        }

        String fileAsString = sb.toString();
        System.out.println(fileAsString);
//
        ExtendedCamelContext extendedCamelContext = camelContext.adapt(ExtendedCamelContext.class);
        RoutesLoader loader = extendedCamelContext.getRoutesLoader();
        Resource resource = ResourceHelper.fromString("sample.yaml", fileAsString);

        Set<String> routes = loader.updateRoutes(resource);
        log.info("Updated routes: " + routes);

        camelContext.getRouteController().startRoute("sample");
    }

}
