package co.edu.uco.carpooling.service.mapper.entityassembler.impl;

import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverEntityAssembler implements EntityAssembler<DriverEntity, DriverDomain, DriverDTO> {

    private final ModelMapper modelMapper;

    public DriverEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DriverDomain assembleDomain(DriverEntity entity) {
        return modelMapper.map(entity, DriverDomain.class);
    }

    @Override
    public DriverEntity assembleEntity(DriverDomain domain) {
        return modelMapper.map(domain, DriverEntity.class);
    }

    @Override
    public DriverDTO assembleDTO(DriverEntity entity) {
        return modelMapper.map(entity, DriverDTO.class);
    }
}
