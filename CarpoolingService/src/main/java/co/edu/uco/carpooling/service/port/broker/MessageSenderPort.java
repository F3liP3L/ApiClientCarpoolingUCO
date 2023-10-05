package co.edu.uco.carpooling.service.port.broker;

public interface MessageSenderPort<T> {
    void execute(T message, String id);
}
