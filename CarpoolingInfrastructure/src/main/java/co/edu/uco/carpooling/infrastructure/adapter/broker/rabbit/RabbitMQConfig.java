package co.edu.uco.carpooling.infrastructure.adapter.broker.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @Value("${api-client.queue.route.request}")
    private String requestRouteQueue;
    @Value("${api-client.queue.route.request-routing-key}")
    private String requestRoutingKey;
    @Value("${api-client.queue.route.response-create}")
    private String responseCreateRouteQueue;
    @Value("${api-client.queue.route.create-routing-key}")
    private String createRouteRoutingKey;
    @Value("${api-client.exchange.route}")
    private String routeExchange;

    @Bean
    public Queue requestRoute() {
        return new Queue(requestRouteQueue);
    }

    @Bean
    public Queue createRoute() {
        return new Queue(responseCreateRouteQueue);
    }
    @Bean
    public DirectExchange routeExchange(){
        return new DirectExchange(routeExchange);
    }

    @Bean
    public Binding routeRequestBinding(){
        return BindingBuilder.bind(requestRoute())
                .to(routeExchange())
                .with(requestRoutingKey);
    }

    @Bean
    public Binding createRoutetBinding(){
        return BindingBuilder.bind(requestRoute())
                .to(routeExchange())
                .with(createRouteRoutingKey);
    }
}