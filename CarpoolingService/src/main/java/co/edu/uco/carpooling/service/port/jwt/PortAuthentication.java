package co.edu.uco.carpooling.service.port.jwt;

import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;

public interface PortAuthentication {
    JwtResponse signIn(JwtRequest request);
    JwtResponse signUp(JwtRequest request);
}
