package com.vikas.JpaManyToMany.Configurtion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfigration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
