package co.edu.uco.carpooling.service.mapper.entityassembler.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssemblerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityAssembler implements EntityAssemblerService<CustomerEntity, CustomerDomain, CustomerDTO> {

    private final ModelMapper modelMapper;

    public CustomerEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CustomerDomain assembleDomain(CustomerEntity entity) {
        return modelMapper.map(entity, CustomerDomain.class);
    }

    @Override
    public CustomerEntity assembleEntity(CustomerDomain domain) {
        return modelMapper.map(domain, CustomerEntity.class);
    }

    @Override
    public CustomerDTO assembleDTO(CustomerEntity entity) {
        return modelMapper.map(entity, CustomerDTO.class);
    }
}
