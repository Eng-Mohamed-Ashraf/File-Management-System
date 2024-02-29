package com.example.filemanagementsystem.dto;

import javax.validation.constraints.NotBlank;


public class SpaceRequest {
	@NotBlank(message = "Name is required")
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}

