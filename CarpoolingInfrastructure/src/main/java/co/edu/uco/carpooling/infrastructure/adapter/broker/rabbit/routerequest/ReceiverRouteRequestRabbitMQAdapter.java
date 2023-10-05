package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routerequest;

import co.edu.uco.carpooling.service.port.broker.route.ReceiverRouteCreatePort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverRouteRequestRabbitMQAdapter implements ReceiverRouteCreatePort {

    @Override
    @RabbitListener(queues = "${api-client.queue.route.response-create}")
    public void execute(String message) {
        System.out.println(message);
    }
}
