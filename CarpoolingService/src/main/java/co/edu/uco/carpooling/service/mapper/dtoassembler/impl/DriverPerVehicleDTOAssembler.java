package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverPerVehicleDTOAssembler implements DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleDomain> {

    private final ModelMapper modelMapper;

    public DriverPerVehicleDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DriverPerVehicleDomain assembleDomain(DriverPerVehicleDTO dto) {
        return modelMapper.map(dto, DriverPerVehicleDomain.class);
    }

    @Override
    public DriverPerVehicleDTO assembleDTO(DriverPerVehicleDomain domain) {
        return modelMapper.map(domain, DriverPerVehicleDTO.class);
    }

}
