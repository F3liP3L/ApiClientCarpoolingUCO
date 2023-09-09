package co.edu.uco.carpooling.adapter.jwt;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAuthenticationService {
    UserDetailsService userDetailsService();
}
