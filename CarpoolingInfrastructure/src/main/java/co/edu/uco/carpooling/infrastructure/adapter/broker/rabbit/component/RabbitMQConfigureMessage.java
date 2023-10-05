package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.component;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.util.Optional;

public interface RabbitMQConfigureMessage {
    MessageProperties generate(String idMessageSender);
    Optional<Message> getBodyMessage(Object object, MessageProperties properties);
}
