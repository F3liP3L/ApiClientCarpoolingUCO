package co.edu.uco.carpooling.service.port.jwt;

import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;

public interface PortAuthentication {
    JwtResponse signIn(JwtRequest request);
    void customerSignUp(CustomerEntity request);
    void driverSignUp(DriverEntity request);
}
