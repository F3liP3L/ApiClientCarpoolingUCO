package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleDTOAssembler implements DTOAssembler<VehicleDTO, VehicleDomain> {

    private final ModelMapper modelMapper;

    public VehicleDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public VehicleDomain assembleDomain(VehicleDTO dto) {
        return modelMapper.map(dto, VehicleDomain.class);
    }

    @Override
    public VehicleDTO assembleDTO(VehicleDomain domain) {
        return modelMapper.map(domain, VehicleDTO.class);
    }
}
