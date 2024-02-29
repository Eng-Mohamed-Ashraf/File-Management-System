package com.example.filemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.filemanagementsystem.model.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
}
