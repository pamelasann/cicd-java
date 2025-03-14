package com.example.cicd_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CicdDemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void helloEndpointReturnsExpectedText() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

		assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(response.getBody()).isEqualTo("Hello World! From Java");
	}
}
