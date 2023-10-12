package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routerequest;

import co.edu.uco.carpooling.crosscutting.util.json.UtilMapperJson;
import co.edu.uco.carpooling.service.component.LatestRouteService;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.ReceiverRouteCreatePort;
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
    private LatestRouteService latestRouteService;

    @Override
    @RabbitListener(queues = "${api-client.queue.route.response-create}")
    public void execute(String message) {
        Optional<RouteDomain> response = mapperJson.execute(message, RouteDomain.class);
        response.ifPresent(domain -> latestRouteService.setLatestRoute(domain));
    }

    @Override
    public RouteDomain getMessage() {
        return latestRouteService.getLatestRoute();
    }

}
