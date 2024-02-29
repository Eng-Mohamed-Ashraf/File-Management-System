package com.example.filemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.filemanagementsystem.model.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
