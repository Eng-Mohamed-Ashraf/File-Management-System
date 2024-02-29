package com.example.filemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.filemanagementsystem.dto.FolderRequest;
import com.example.filemanagementsystem.model.Folder;
import com.example.filemanagementsystem.model.Space;
import com.example.filemanagementsystem.repository.FolderRepository;
import com.example.filemanagementsystem.repository.SpaceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FolderService {

    @Autowired
    private SpaceRepository spaceRepository;
    
    @Autowired
    private FolderRepository folderRepository; 

    @Transactional
    public Long createFolder(Long spaceId, FolderRequest request) throws Exception {
        // Check if the space exists
        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new EntityNotFoundException("Space not found with ID: " + spaceId));
        
        // Check permission to create folder (e.g., based on user roles)
        if (!hasPermissionToCreateFolder(space)) {
            throw new Exception("You do not have permission to create a folder in this space");
        }
        
        // Create and save the folder
        Folder folder = new Folder();
        folder.setName(request.getName());
        folder.setSpace(space);
        
        folderRepository.save(folder);
        
        return folder.getId();
    }
    
    private boolean hasPermissionToCreateFolder(Space space) {
        // Implement logic to check user's permission to create folder in the given space
        // Example: Check if the user is an admin or has edit permission on the space
        // You can use Spring Security's authentication context to get the current user's information
        return true; // Placeholder, actual implementation required
    }
}
