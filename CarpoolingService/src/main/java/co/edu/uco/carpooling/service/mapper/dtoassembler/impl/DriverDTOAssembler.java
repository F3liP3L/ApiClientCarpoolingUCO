package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverDTOAssembler implements DTOAssembler<DriverDTO, DriverDomain> {

    private final ModelMapper modelMapper;

    public DriverDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DriverDomain assembleDomain(DriverDTO dto) {
        return modelMapper.map(dto, DriverDomain.class);
    }

    @Override
    public DriverDTO assembleDTO(DriverDomain domain) {
        return modelMapper.map(domain, DriverDTO.class);
    }
}
