package com.cos.flux.web;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.cos.flux.domain.Customer;
import com.cos.flux.domain.CustomerRepository;

import reactor.core.publisher.Mono;

@WebFluxTest
public class CustomerControllerTest {

	@MockBean
	CustomerRepository customerRepository;
	
	@Autowired
	private WebTestClient webClient;
	
	Mono<Customer> givenData =Mono.just(new Customer("Jack", "Bauer"));
	
	@Test
	public void 찾기_테스트() {
		
		when(customerRepository.findById(1L)).thenReturn(givenData);
		
		webClient.get().uri("/customer/{id}", 1L)
		.exchange()
		.expectBody()
		.jsonPath("$.firstName").isEqualTo("Jack")
		.jsonPath("$.lastName").isEqualTo("Bauer");
	}
}
