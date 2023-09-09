package co.edu.uco.carpooling.adapter.jwt;

import co.edu.uco.carpooling.adapter.repository.postgressql.CustomerRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.port.jwt.PortUserAuthenticationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class JwtUserAuthenticationDetailsAdapter implements UserAuthenticationService, PortUserAuthenticationDetails<CustomerEntity> {
    @Autowired
    private CustomerRepositoryPostgresSQL customerRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public CustomerEntity save(CustomerEntity userAuthenticate) {
       userAuthenticate.setPassword(bcryptEncoder.encode(userAuthenticate.getPassword()));
       return customerRepository.save(userAuthenticate);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Optional<CustomerEntity> customer = customerRepository.findByCompanyEmail(email);
                if (customer.isEmpty()) {
                    throw new UsernameNotFoundException("The user with the email was not found: ".concat(email));
                }
                return new User(customer.get().getCompanyEmail(), customer.get().getPassword(),
                        new ArrayList<>());
            }
        };
    }
}
