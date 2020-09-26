package com.dfth2020.acceptance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTest extends BaseAcceptanceTest {

    @LocalServerPort
    private int port;

    @Test
    public void ensureGetHelloWorldReturnsResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String helloWorld = restTemplate.getForObject("http://localhost:" + port + "/api/hello/world", String.class);

        assertThat(helloWorld).isEqualTo("hello world");
    }
}
