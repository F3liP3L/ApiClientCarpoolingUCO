package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.RouteRequestDTO;
import co.edu.uco.carpooling.service.domain.RouteRequestDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteRequestDTOAssembler implements DTOAssembler<RouteRequestDTO, RouteRequestDomain> {
    private final ModelMapper modelMapper;
    public RouteRequestDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public RouteRequestDomain assembleDomain(RouteRequestDTO dto) {
        return modelMapper.map(dto, RouteRequestDomain.class);
    }
    @Override
    public RouteRequestDTO assembleDTO(RouteRequestDomain domain) {
        return modelMapper.map(domain, RouteRequestDTO.class);
    }
}
