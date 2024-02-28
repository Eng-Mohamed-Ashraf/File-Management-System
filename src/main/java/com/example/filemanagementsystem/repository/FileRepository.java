package com.example.filemanagementsystem.repository;

import com.example.filemanagementsystem.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
