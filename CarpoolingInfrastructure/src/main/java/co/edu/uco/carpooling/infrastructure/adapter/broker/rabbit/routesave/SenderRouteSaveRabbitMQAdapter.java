package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routesave;

import co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.component.RabbitMQConfigureMessage;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteSavePort;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SenderRouteSaveRabbitMQAdapter implements SenderRouteSavePort {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQConfigureMessage configureMessage;
    @Value("${api-client.queue.route.save-routing-key}")
    private String saveRouteRoutingKey;
    @Value("${api-client.exchange.route}")
    private String routeExchange;
    @Override
    public void execute(RouteDomain message, String id) {
        MessageProperties propertiesMessage = configureMessage.generate(id);
        Optional<Message> bodyMessage = configureMessage.getBodyMessage(message, propertiesMessage);
        if (bodyMessage.isEmpty()) {
            return;
        }
        rabbitTemplate.convertAndSend(routeExchange, saveRouteRoutingKey, bodyMessage.get());
    }
}
