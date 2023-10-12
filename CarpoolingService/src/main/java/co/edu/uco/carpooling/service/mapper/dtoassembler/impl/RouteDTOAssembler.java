package co.edu.uco.carpooling.service.mapper.dtoassembler.impl;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteDTOAssembler implements DTOAssembler<RouteDTO, RouteDomain> {
    private ModelMapper modelMapper;
    public RouteDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public RouteDomain assembleDomain(RouteDTO dto) {
        return modelMapper.map(dto, RouteDomain.class);
    }
    @Override
    public RouteDTO assembleDTO(RouteDomain domain) {
        return modelMapper.map(domain, RouteDTO.class);
    }
}
