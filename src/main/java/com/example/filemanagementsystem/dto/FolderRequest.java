package com.example.filemanagementsystem.dto;

import javax.validation.constraints.NotBlank;

public class FolderRequest {
    @NotBlank(message = "Folder name is required")
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}

