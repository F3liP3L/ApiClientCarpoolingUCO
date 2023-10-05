package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit.component;

import co.edu.uco.carpooling.crosscutting.util.UtilMapperJson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RabbitMQConfigureMessageImpl implements RabbitMQConfigureMessage{
    @Autowired
    private UtilMapperJson mapperJson;
    @Override
    public MessageProperties generate(String idMessageSender) {
        return MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setHeader("id", idMessageSender)
                .build();
    }

    @Override
    public Optional<Message> getBodyMessage(Object object, MessageProperties properties) {
        Optional<String> textMessage = mapperJson.executeGson(object);
        return textMessage.map(msg -> MessageBuilder
                .withBody(msg.getBytes())
                .andProperties(properties)
                .build());
    }
}
