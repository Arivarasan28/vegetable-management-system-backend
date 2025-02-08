package com.vms.vegetable_management_system_backend.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VegetableDTO {

    private int id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private String vegetableImage;
}
