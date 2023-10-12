package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.route.FindRouteCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindRouteCreateUseCaseImpl implements FindRouteCreateUseCase {
    @Autowired
    private DTOAssembler<RouteDTO, RouteDomain> dtoAssembler;
    @Override
    public RouteDTO execute(RouteDomain objectMessage) {
        return dtoAssembler.assembleDTO(objectMessage);
    }
}
