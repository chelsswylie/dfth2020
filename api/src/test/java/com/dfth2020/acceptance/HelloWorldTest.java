package com.dfth2020.acceptance;

import com.dfth2020.client.ApiClient;
import com.dfth2020.client.api.HelloWorldApi;
import com.dfth2020.client.model.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldTest extends BaseAcceptanceTest {

    @Test
    public void ensureGetHelloWorldReturnsResponse() {
        HelloWorldApi helloWorldApi = new HelloWorldApi(getApiClient());

        HelloWorld helloWorld = helloWorldApi.helloWorldGet();

        assertThat(helloWorld.getHello()).isEqualTo("world");
    }
}
