package com.vms.vegetable_management_system_backend.repository;

import com.vms.vegetable_management_system_backend.model.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

    // Custom query methods if needed
    List<Vegetable> findByCategory(String category);
}