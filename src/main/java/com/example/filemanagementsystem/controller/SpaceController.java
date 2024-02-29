package com.example.filemanagementsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.filemanagementsystem.dto.SpaceRequest;
import com.example.filemanagementsystem.service.SpaceService;

@RestController
public class SpaceController {
    
    @Autowired
    private SpaceService spaceService;

    @PostMapping("/spaces")
    public ResponseEntity<String> createSpace(@RequestBody SpaceRequest request) {
        Long spaceId = spaceService.createSpace(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Space created with ID: " + spaceId);
    }
}
