package com.example.filemanagementsystem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.filemanagementsystem.dto.FolderRequest;
import com.example.filemanagementsystem.service.FolderService;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/spaces/{spaceId}/folders")
@Validated
public class FolderController {
    
    @Autowired
    private FolderService folderService;

    @PostMapping
    public ResponseEntity<String> createFolder(
            @PathVariable Long spaceId,
            @Valid @RequestBody FolderRequest request,
            BindingResult bindingResult
    ) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        
        Long folderId = folderService.createFolder(spaceId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Folder created with ID: " + folderId);
    }
}
