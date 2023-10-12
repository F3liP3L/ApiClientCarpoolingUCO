package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.routerequest;

import co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.component.RabbitMQConfigureMessage;
import co.edu.uco.carpooling.service.domain.requestroute.RouteRequestDomain;
import co.edu.uco.carpooling.service.port.broker.route.SenderRouteRequestPort;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SenderRouteRequestPortRabbitMQAdapter implements SenderRouteRequestPort {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitMQConfigureMessage configureMessage;
    @Value("${api-client.queue.route.request-routing-key}")
    private String requestRoutingKey;
    @Value("${api-client.exchange.route}")
    private String routeExchange;
    @Override
    public void execute(RouteRequestDomain message, String id) {
        MessageProperties propertiesMessage = configureMessage.generate(id);
        Optional<Message> bodyMessage = configureMessage.getBodyMessage(message, propertiesMessage);
        if (bodyMessage.isEmpty()) {
            return;
        }
        rabbitTemplate.convertAndSend(routeExchange, requestRoutingKey, bodyMessage.get());
    }
}
