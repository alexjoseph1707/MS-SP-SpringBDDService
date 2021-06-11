package org.example.integration;

import org.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:";

    @Test
    public void simpleTest(){
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl+port+"/actuator/health",String.class);
    System.out.println(response.getBody());
    }
}
