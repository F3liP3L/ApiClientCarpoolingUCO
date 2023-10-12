package co.edu.uco.carpooling.infrastructure.adapter.broker;

import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.port.broker.PortBroker;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ConsumerBrokerAdapter implements PortBroker {
    @Override
    @RabbitListener(queues = "${client.queue-recibir.cliente.queue-name}")
    public RouteDomain consumerBroker() {
        try {
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
