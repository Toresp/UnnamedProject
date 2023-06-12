package com.example.miguelS.provisionalname;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.miguelS.provisionalname.infrastructure.controllers.Constants.PRICES;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ProvisionalnameApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecieveDataControllerEndToEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @BeforeEach
    void init() {
        url = "http://localhost:" + port + PRICES;

    }

    @Test
    void testPricesEndpointFirstCase() {

        String appDate = "2020-06-14T10:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;
        ResponseEntity<String> response = restTemplate.getForEntity(url + "?appDate={appDate}&productId={productId}&brandId={brandId}", String.class, appDate, productId, brandId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPricesEndpointSecondCase() {
        String appDate = "2020-06-14T16:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;
        ResponseEntity<String> response = restTemplate.getForEntity(url + "?appDate={appDate}&productId={productId}&brandId={brandId}", String.class, appDate, productId, brandId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPricesEndpointThirdCase() {
        String appDate = "2020-06-14T21:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;
        ResponseEntity<String> response = restTemplate.getForEntity(url + "?appDate={appDate}&productId={productId}&brandId={brandId}", String.class, appDate, productId, brandId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPricesEndpointFourthCase() {
        String appDate = "2020-06-15T10:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;
        ResponseEntity<String> response = restTemplate.getForEntity(url + "?appDate={appDate}&productId={productId}&brandId={brandId}", String.class, appDate, productId, brandId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPricesEndpointFifth() {
        String appDate = "2020-06-16T21:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;
        ResponseEntity<String> response = restTemplate.getForEntity(url + "?appDate={appDate}&productId={productId}&brandId={brandId}", String.class, appDate, productId, brandId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}