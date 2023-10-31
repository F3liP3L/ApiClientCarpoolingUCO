package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.FindRouteCreateUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class FindRouteCreateUseCaseImpl implements FindRouteCreateUseCase {
    private final EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    private final UtilMapperJson mapperJson;
    private final RouteRepository routeRepository;

    public FindRouteCreateUseCaseImpl(EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler, UtilMapperJson mapperJson, RouteRepository routeRepository) {
        this.entityAssembler = entityAssembler;
        this.mapperJson = mapperJson;
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteDTO execute(UUID id) {
        RouteDTO route;
        Optional<RouteEntity> response = routeRepository.findByRoute(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The route is not registered.");
        }
        route = entityAssembler.assembleDTO(response.get());
        try {
            route.setPositions(mapperJson.execute(response.get().getPositions(), new TypeReference<>() {}));
        } catch (JsonProcessingException exception) {
            throw CarpoolingCustomException.buildTechnicalException(exception.getMessage());
        }
        return route;
    }
}
