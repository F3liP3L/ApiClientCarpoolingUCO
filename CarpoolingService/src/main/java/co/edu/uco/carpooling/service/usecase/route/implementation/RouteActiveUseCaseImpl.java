package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.RouteActiveUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteActiveUseCaseImpl implements RouteActiveUseCase {
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private UtilMapperJson mapperJson;
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public List<RouteDTO> execute(Optional<RouteDTO> dto) {
        List<RouteDTO> routes = new ArrayList<>();
        List<RouteEntity> routeEntities = routeRepository.findRouteActive();
        /*routeEntities.forEach(elem -> {
            try {
                elem.setPositions(mapperJson.execute(elem.getPositions(), new TypeReference<List<RouteDTO>>() {}).toString());
            } catch (JsonProcessingException exception) {
                throw CarpoolingCustomException.buildUserException(exception.getMessage());
            }
        });*/
        return routeRepository.findRouteActive().stream().map(entity -> entityAssembler.assembleDTO(entity)).toList();
    }
}
