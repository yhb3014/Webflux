package com.cos.flux.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Customer {
	
	@Id
    private Long id;

    private final String firstName;

    private final String lastName;

}
