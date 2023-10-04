package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit;

import co.edu.uco.carpooling.crosscutting.util.UtilMapperJson;
import co.edu.uco.carpooling.service.domain.RouteRequestDomain;
import co.edu.uco.carpooling.service.port.broker.MessageSender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrokerSenderRabbitMQAdapter implements MessageSender<RouteRequestDomain> {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UtilMapperJson mapperJson;
    @Value("${api-client.queue.route.request-routing-key}")
    private String requestRoutingKey;
    @Value("${api-client.exchange.route}")
    private String routeExchange;
    @Override
    public void execute(RouteRequestDomain message, String id) {
        MessageProperties propertiesMessage = generateMessageProperties(id);
        Optional<Message> bodyMessage = getBodyMessage(message, propertiesMessage);
        if (bodyMessage.isEmpty()) {
            return;
        }
        rabbitTemplate.convertAndSend(routeExchange, requestRoutingKey, bodyMessage.get());
    }

    private MessageProperties generateMessageProperties(String idMessageSender ) {
        return MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setHeader("id", idMessageSender)
                .build();
    }

    private Optional<Message> getBodyMessage(Object message, MessageProperties propiedadesMensaje) {
        Optional<String> textMessage = mapperJson.executeGson(message);
        return textMessage.map(msg -> MessageBuilder
                .withBody(msg.getBytes())
                .andProperties(propiedadesMensaje)
                .build());
    }
}
