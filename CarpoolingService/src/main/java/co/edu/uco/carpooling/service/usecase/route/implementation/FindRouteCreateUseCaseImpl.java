package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.FindRouteCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindRouteCreateUseCaseImpl implements FindRouteCreateUseCase {
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public RouteDTO execute(UUID id) {
        Optional<RouteEntity> response = routeRepository.findByRoute(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("La ruta no se encuentra registrada");
        }
        RouteDTO route = new RouteDTO();

        return entityAssembler.assembleDTO(response.get());
    }
}
