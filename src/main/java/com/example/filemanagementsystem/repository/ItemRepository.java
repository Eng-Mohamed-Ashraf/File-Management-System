package com.example.filemanagementsystem.repository;

import com.example.filemanagementsystem.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
