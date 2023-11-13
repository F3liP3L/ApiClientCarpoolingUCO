package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.PositionDTO;
import co.edu.uco.carpooling.dto.requestroute.RouteAvailableDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.requestroute.RouteAvailableDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.RouteActiveUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RouteActiveUseCaseImpl implements RouteActiveUseCase {
    @Autowired
    private EntityAssembler<RouteEntity, RouteAvailableDomain, RouteAvailableDTO> entityAssembler;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private UtilMapperJson mapperJson;
    @Override
    public List<RouteAvailableDTO> execute(Optional<RouteAvailableDTO> dto) {
        List<RouteEntity> routeEntities = routeRepository.findRouteActive();
        if (routeEntities.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("No active route is available");
        }
        return routeEntities.stream().map(route -> {
            RouteAvailableDTO routeAvailable = entityAssembler.assembleDTO(route);
            routeAvailable.setOrigin(mapperJson.execute(route.getOrigin(), PositionDTO.class).get());
            routeAvailable.setDestination(mapperJson.execute(route.getDestination(), PositionDTO.class).get());
            return routeAvailable;
        }).toList();
    }
}
