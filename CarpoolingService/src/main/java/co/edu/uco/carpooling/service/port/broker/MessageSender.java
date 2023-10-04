package co.edu.uco.carpooling.service.port.broker;

public interface MessageSender<T> {
    void execute(T message, String id);
}
