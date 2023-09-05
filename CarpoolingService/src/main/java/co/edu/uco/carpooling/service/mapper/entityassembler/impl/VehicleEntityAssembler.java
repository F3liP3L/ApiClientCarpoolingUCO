package co.edu.uco.carpooling.service.mapper.entityassembler.impl;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleEntityAssembler implements EntityAssembler<VehicleEntity, VehicleDomain, VehicleDTO> {

    private final ModelMapper modelMapper;

    public VehicleEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public VehicleDomain assembleDomain(VehicleEntity entity) {
        return modelMapper.map(entity, VehicleDomain.class);
    }

    @Override
    public VehicleEntity assembleEntity(VehicleDomain domain) {
        return modelMapper.map(domain, VehicleEntity.class);
    }

    @Override
    public VehicleDTO assembleDTO(VehicleEntity entity) {
        return modelMapper.map(entity, VehicleDTO.class);
    }
}
