package com.example.filemanagementsystem.repository;

import com.example.filemanagementsystem.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}

