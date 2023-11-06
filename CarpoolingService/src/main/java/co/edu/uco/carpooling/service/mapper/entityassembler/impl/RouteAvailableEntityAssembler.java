package co.edu.uco.carpooling.service.mapper.entityassembler.impl;

import co.edu.uco.carpooling.dto.requestroute.RouteAvailableDTO;
import co.edu.uco.carpooling.dto.requestroute.RouteRequestDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.requestroute.RouteAvailableDomain;
import co.edu.uco.carpooling.service.domain.requestroute.RouteRequestDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteAvailableEntityAssembler implements EntityAssembler<RouteEntity, RouteAvailableDomain, RouteAvailableDTO> {
    private final ModelMapper modelMapper;

    public RouteAvailableEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public RouteAvailableDomain assembleDomain(RouteEntity entity) {
        return modelMapper.map(entity, RouteAvailableDomain.class);
    }

    @Override
    public RouteEntity assembleEntity(RouteAvailableDomain domain) {
        return modelMapper.map(domain, RouteEntity.class);
    }
    @Override
    public RouteAvailableDTO assembleDTO(RouteEntity entity) {
        return modelMapper.map(entity, RouteAvailableDTO.class);
    }
}
