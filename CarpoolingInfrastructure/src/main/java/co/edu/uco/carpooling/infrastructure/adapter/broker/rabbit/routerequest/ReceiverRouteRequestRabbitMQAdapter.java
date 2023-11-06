package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routerequest;

import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.broker.route.ReceiverRouteCreatePort;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ReceiverRouteRequestRabbitMQAdapter implements ReceiverRouteCreatePort {
    @Autowired
    private UtilMapperJson mapperJson;
    @Autowired
    private EntityAssembler<RouteEntity, RouteDomain, RouteDTO> entityAssembler;
    @Autowired
    private RouteRepository routeRepository;

    @Override
    @RabbitListener(queues = "${api-client.queue.route.response-create}")
    public void execute(String message) {
        log.info(message);
        Optional<RouteDomain> response = mapperJson.execute(message, RouteDomain.class);
        log.info(response.get().toString());
        response.ifPresent(this::accept);
    }

    private void accept(RouteDomain routeDomain) {
        RouteEntity route = entityAssembler.assembleEntity(routeDomain);
        route.setStatus("Creada");
        Optional<String> response = mapperJson.execute(routeDomain.getPositions());
        response.ifPresent(route::setPositions);
        log.info(route.toString());
        routeRepository.save(route);
    }
}
