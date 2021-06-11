package org.example.cucmber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:";
    ResponseEntity<String> response = null;
    private static final String responseBody = "response for the get request";

    @Given("application is running")
    public void application_is_running() {
        response = restTemplate.getForEntity(baseUrl+port+"/actuator/health",String.class);
        assertThat("Actuator validation",response.getStatusCode(),is(HttpStatus.OK));
    }
    @When("I send a get request")
    public void i_send_a_get_request() {
        response = restTemplate.getForEntity(baseUrl+port+"/getAPI",String.class);
    }
    @Then("I should get success response")
    public void i_should_get_success_response() {
        assertThat("getAPI validation",response.getStatusCode(),is(HttpStatus.OK));
        assertThat("getAPI validation",response.getBody(),is(responseBody));
    }

}
