package com.vms.vegetable_management_system_backend.config;

import com.vms.vegetable_management_system_backend.model.DTO.VegetableCreateDTO;
import com.vms.vegetable_management_system_backend.model.Vegetable;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<VegetableCreateDTO, Vegetable>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
        return modelMapper;
    }
}
