package com.example.filemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.filemanagementsystem.dto.SpaceRequest;
import com.example.filemanagementsystem.model.Space;
import com.example.filemanagementsystem.repository.SpaceRepository;

@Service
public class SpaceService {

    @Autowired
    private SpaceRepository spaceRepository;

    @Transactional
    public Long createSpace(SpaceRequest request) {
        Space space = new Space();
        space.setName(request.getName());
        
        // Additional logic to assign permission group
        
        spaceRepository.save(space);
        
        return space.getId();
    }
}
