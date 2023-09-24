package co.edu.uco.carpooling.adapter.jwt;

import co.edu.uco.carpooling.adapter.jwt.model.UserInformationDetailsService;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.model.JwtRequest;
import co.edu.uco.carpooling.service.model.JwtResponse;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticateAdapter  implements PortAuthentication {

    @Autowired
    private UserInformationDetailsService userInformationDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;
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
                throw CarpoolingCustomException.buildUserException("The credentials entered are incorrect.");
            }
            final UserDetails userDetails = userInformationDetailsService
                .loadUserByUsername(request.getEmail());
            final String jwt = tokenService.generateToken(userDetails.getUsername());
            return new JwtResponse(jwt);
    }

    @Override
    public void signUp(CustomerEntity request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        customerRepository.save(request);
    }
}
