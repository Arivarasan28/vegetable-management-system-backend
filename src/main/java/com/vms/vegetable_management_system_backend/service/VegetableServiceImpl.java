package com.vms.vegetable_management_system_backend.service;

import com.vms.vegetable_management_system_backend.model.DTO.VegetableCreateDTO;
import com.vms.vegetable_management_system_backend.model.DTO.VegetableDTO;
import com.vms.vegetable_management_system_backend.model.Vegetable;
import com.vms.vegetable_management_system_backend.repository.VegetableRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VegetableServiceImpl implements VegetableService {
    @Autowired
    private VegetableRepository vegetableRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<VegetableDTO> findAll() {
        return vegetableRepository.findAll().stream()
                .map(vegetable -> modelMapper.map(vegetable, VegetableDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VegetableDTO findById(int theId) {
        Vegetable vegetable = vegetableRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Vegetable not found: " + theId));
        return modelMapper.map(vegetable, VegetableDTO.class);
    }

    @Override
    public Vegetable save(VegetableCreateDTO theVegetableCreateDTO) {
        Vegetable vegetable = modelMapper.map(theVegetableCreateDTO, Vegetable.class);
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void deleteById(int theId) {
        vegetableRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public VegetableDTO update(int vegetableId, VegetableCreateDTO vegetableCreateDTO) {
        Vegetable existingVegetable = vegetableRepository.findById(vegetableId)
                .orElseThrow(() -> new RuntimeException("Vegetable not found: " + vegetableId));

        existingVegetable.setName(vegetableCreateDTO.getName());
        existingVegetable.setPrice(vegetableCreateDTO.getPrice());
        existingVegetable.setDescription(vegetableCreateDTO.getDescription());
        existingVegetable.setCategory(vegetableCreateDTO.getCategory());
        existingVegetable.setVegetableImage(vegetableCreateDTO.getVegetableImage());

        Vegetable updatedVegetable = vegetableRepository.save(existingVegetable);
        return modelMapper.map(updatedVegetable, VegetableDTO.class);
    }
}
