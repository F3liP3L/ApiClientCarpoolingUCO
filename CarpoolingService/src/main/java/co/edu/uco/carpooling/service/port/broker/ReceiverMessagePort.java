package co.edu.uco.carpooling.service.port.broker;


public interface ReceiverMessagePort<M> {
    void execute(M message);
}
