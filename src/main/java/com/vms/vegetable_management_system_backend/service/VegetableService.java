package com.vms.vegetable_management_system_backend.service;

import com.vms.vegetable_management_system_backend.model.DTO.VegetableCreateDTO;
import com.vms.vegetable_management_system_backend.model.DTO.VegetableDTO;
import com.vms.vegetable_management_system_backend.model.Vegetable;

import java.util.List;

public interface VegetableService {

    List<VegetableDTO> findAll();

    VegetableDTO findById(int theId);

    Vegetable save(VegetableCreateDTO theVegetableCreateDTO);

    void deleteById(int theId);

    VegetableDTO update(int VegetableId, VegetableCreateDTO vegetableCreateDTO);

    List<VegetableDTO> findByCategory(String category);
}