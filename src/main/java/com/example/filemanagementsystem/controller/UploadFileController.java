package com.example.filemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.filemanagementsystem.service.FileStorageService;

@RestController
@RequestMapping("/folders/{folderId}/upload")
public class UploadFileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public ResponseEntity<String> uploadFile(
            @PathVariable Long folderId,
            @RequestParam("file") MultipartFile file
    ) throws Exception {
        String fileName = fileStorageService.storeFile(file, folderId);
        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully with name: " + fileName);
    }
}
