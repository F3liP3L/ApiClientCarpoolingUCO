package co.edu.uco.carpooling.service.port.jwt;

public interface PortUserAuthenticationDetails<T> {
    T save(T userAuthenticate);
}
