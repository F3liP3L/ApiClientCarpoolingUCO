package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routeactive;

import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.broker.route.ReceiveActiveRoutePort;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ReceiveActiveRouteRabbitMQAdapter implements ReceiveActiveRoutePort {
    @Autowired
    private UtilMapperJson mapperJson;
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private RouteRepository routeRepository;
    @Override
    //@RabbitListener(queues = "${api-client.queue.route.response-create}")
    public void execute(String message) {
        Optional<RouteDomain> response = mapperJson.execute(message, RouteDomain.class);
        response.ifPresent(this::accept);
    }

    private void accept(RouteDomain routeDomain) {
        RouteEntity route = entityAssembler.assembleEntity(routeDomain);
        Optional<String> response = mapperJson.execute(routeDomain.getPositions());
        response.ifPresent(route::setPositions);
        log.info(route.toString());
        routeRepository.save(route);
    }
}
