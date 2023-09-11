package co.edu.uco.carpooling.adapter.jwt;

import co.edu.uco.carpooling.adapter.jwt.model.UserInformationDetailsService;
import co.edu.uco.carpooling.adapter.repository.postgressql.impl.CustomerRepositoryJpa;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticateAdapter  implements PortAuthentication {

    @Autowired
    private UserInformationDetailsService userInformationDetailsService;
    @Autowired
    private JwtTokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public JwtResponse signIn(JwtRequest request) {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            } catch (BadCredentialsException exception) {
                throw CarpoolingCustomException.buildUserException("Las creedencias digitadas son incorrectas.");
            }
            final UserDetails userDetails = userInformationDetailsService
                .loadUserByUsername(request.getEmail());
            final String jwt = tokenService.generateToken(userDetails.getUsername());
            return new JwtResponse(jwt);
    }

    @Override
    public JwtResponse signUp(JwtRequest request) {
        return null;
    }
}
