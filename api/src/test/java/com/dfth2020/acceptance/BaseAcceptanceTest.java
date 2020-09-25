package com.dfth2020.acceptance;

import com.dfth2020.client.ApiClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseAcceptanceTest {

    @LocalServerPort
    private int port;

    protected ApiClient getApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:" + port + "/api");
        return apiClient;
    }
}
