package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteSavePort;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.specification.impl.route.ValidRouteSpecification;
import co.edu.uco.carpooling.service.usecase.route.SaveRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaveRouteUseCaseImpl implements SaveRouteUseCase {
    @Autowired
    private SenderRouteSavePort senderRouteSavePort;
    @Autowired
    private ValidRouteSpecification specification;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private UtilMapperJson mapperJson;
    @Override
    public void execute(RouteDomain domain) {
        try {
            domain.setStatus("Activa");
            specification.isSatisfyBy(domain);
            RouteEntity route = entityAssembler.assembleEntity(domain);
            Optional<String> response = mapperJson.execute(domain.getPositions());
            response.ifPresent(route::setPositions);
            Optional<String> origin = mapperJson.execute(domain.getPositions().get(0));
            origin.ifPresent(route::setOrigin);
            Optional<String> destination = mapperJson.execute(domain.getPositions().get(domain.getPositions().size()-1));
            destination.ifPresent(route::setDestination);
            routeRepository.save(route);
            senderRouteSavePort.execute(domain, domain.getId().toString());
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException(exception.getUserMessage());
        }

    }
}
