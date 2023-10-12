package co.edu.uco.carpooling.service.port.broker;


public interface ReceiverMessagePort<M,T> {
    void execute(M message);
    T getMessage();
}
