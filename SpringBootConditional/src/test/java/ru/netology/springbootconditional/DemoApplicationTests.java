package ru.netology.springbootconditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    public static GenericContainer<?> containerDev = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    public static GenericContainer<?> containerProd = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {

    }


    @Test
    void contextLoadsDev() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:"
                + containerDev.getMappedPort(8080), String.class);
        System.out.println(forEntity.getBody());
        Assertions.assertEquals(forEntity, forEntity.getBody());
    }

    @Test
    void contextLoadsProd() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:"
                + containerProd.getMappedPort(8081), String.class);
        System.out.println(forEntity.getBody());
        Assertions.assertEquals(forEntity, forEntity.getBody());
    }

}
