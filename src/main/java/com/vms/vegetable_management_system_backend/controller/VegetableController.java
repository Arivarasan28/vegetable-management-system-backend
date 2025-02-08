package com.vms.vegetable_management_system_backend.controller;

import com.vms.vegetable_management_system_backend.model.DTO.VegetableCreateDTO;
import com.vms.vegetable_management_system_backend.model.DTO.VegetableDTO;
import com.vms.vegetable_management_system_backend.model.Vegetable;
import com.vms.vegetable_management_system_backend.service.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/vegetable")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/")
    public List<VegetableDTO> findAll() {
        return vegetableService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/{vegetableId}")
    public VegetableDTO getVegetable(@PathVariable int vegetableId) {
        return vegetableService.findById(vegetableId);
    }

    @PostMapping("/create")
    public VegetableDTO addVegetable(@RequestBody VegetableCreateDTO theVegetableCreateDTO) {
        // Save the vegetable entity
        Vegetable savedVegetable = vegetableService.save(theVegetableCreateDTO);

        // Fetch the saved entity again to ensure the ID is populated
        VegetableDTO vegetableDTO = vegetableService.findById(savedVegetable.getId());

        return vegetableDTO;
    }

    @DeleteMapping("/{vegetableId}")
    public String deleteVegetable(@PathVariable int vegetableId) {
        vegetableService.deleteById(vegetableId);
        return "Deleted vegetable id: " + vegetableId;
    }

    @PutMapping("/{vegetableId}")
    public VegetableDTO updateVegetable(@PathVariable int vegetableId, @RequestBody VegetableCreateDTO vegetableCreateDTO) {
        return vegetableService.update(vegetableId, vegetableCreateDTO);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/category/{category}")
    public List<VegetableDTO> getVegetablesByCategory(@PathVariable String category) {
        return vegetableService.findByCategory(category);
    }

}
