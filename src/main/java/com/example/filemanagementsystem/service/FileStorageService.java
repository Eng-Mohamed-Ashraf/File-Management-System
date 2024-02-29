package com.example.filemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.filemanagementsystem.model.Folder;
import com.example.filemanagementsystem.repository.FolderRepository;

import jakarta.persistence.EntityNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    // Directory where uploaded files will be stored
    private static final String UPLOAD_DIR = "./uploads/";

    @Autowired
    private FolderRepository folderRepository;

    public String storeFile(MultipartFile file, Long folderId) throws Exception {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the folder exists
            Folder folder = folderRepository.findById(folderId)
                    .orElseThrow(() -> new EntityNotFoundException("Folder not found with ID: " + folderId));

            // Create directory if it doesn't exist
            Files.createDirectories(Paths.get(UPLOAD_DIR));

            // Copy file to the target location
            Path targetLocation = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), targetLocation);

            // Additional logic to save file information in the database, if needed

            return fileName;
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
