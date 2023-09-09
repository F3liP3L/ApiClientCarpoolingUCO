package co.edu.uco.carpooling.adapter.jwt;

import co.edu.uco.carpooling.adapter.jwt.jobs.JwtTokenUtil;
import co.edu.uco.carpooling.adapter.repository.postgressql.CustomerRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationAdapter implements PortAuthentication{
    private final JwtTokenUtil jwtService;
    private final AuthenticationManager authenticationManager;
    private final JwtUserAuthenticationDetailsAdapter userAuthenticationService;

    public JwtAuthenticationAdapter(JwtTokenUtil jwtService, AuthenticationManager authenticationManager, JwtUserAuthenticationDetailsAdapter userAuthenticationDetailsAdapter) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userAuthenticationService = userAuthenticationDetailsAdapter;
    }

    @Override
    public JwtResponse SignIn(JwtRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var jwt = jwtService.generateToken(userAuthenticationService.userDetailsService().loadUserByUsername(request.getEmail()));
        return JwtResponse.builder().token(jwt).build();
    }
    @Override
    public JwtResponse SignUp(JwtRequest request) {
        var jwt = jwtService.generateToken(userAuthenticationService.userDetailsService().loadUserByUsername(request.getEmail()));
        return JwtResponse.builder().token(jwt).build();
    }
}
