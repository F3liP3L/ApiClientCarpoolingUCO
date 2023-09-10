package co.edu.uco.carpooling.adapter.jwt;

import co.edu.uco.carpooling.adapter.jwt.component.JwtTokenService;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationAdapter implements PortAuthentication {
    @Autowired
    private JwtTokenService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUserAuthenticationDetailsAdapter userAuthenticationService;

    @Override
    public JwtResponse signIn(JwtRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var jwt = jwtService.generateToken(userAuthenticationService.userDetailsService().loadUserByUsername(request.getEmail()));
            return JwtResponse.builder().token(jwt).build();
        } catch (DisabledException e) {
            throw CarpoolingCustomException.buildUserException("USER_DISABLED");
        } catch (BadCredentialsException e) {
            throw CarpoolingCustomException.buildUserException("INVALID_CREDENTIALS");
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.buildUserException(exception.getMessage());
        }
    }
    @Override
    public JwtResponse signUp(JwtRequest request) {
        var jwt = jwtService.generateToken(userAuthenticationService.userDetailsService().loadUserByUsername(request.getEmail()));
        return JwtResponse.builder().token(jwt).build();
    }
}
