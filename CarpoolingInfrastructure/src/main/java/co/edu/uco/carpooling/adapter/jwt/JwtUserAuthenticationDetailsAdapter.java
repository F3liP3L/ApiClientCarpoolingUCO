package co.edu.uco.carpooling.adapter.jwt;

import co.edu.uco.carpooling.adapter.repository.postgressql.impl.CustomerRepositoryJpa;
import co.edu.uco.carpooling.entity.CustomerEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserAuthenticationDetailsAdapter implements UserAuthenticationService {

    private final CustomerRepositoryJpa repositoryPostgresSQL;

    public JwtUserAuthenticationDetailsAdapter(CustomerRepositoryJpa repositoryPostgresSQL) {
        this.repositoryPostgresSQL = repositoryPostgresSQL;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Optional<CustomerEntity> customer = repositoryPostgresSQL.findByCompanyEmail(email);
                if (customer.isEmpty()) {
                    throw new UsernameNotFoundException("The user with the email was not found: ".concat(email));
                }
                return new User(customer.get().getCompanyEmail(), customer.get().getPassword(),
                        new ArrayList<>());
            }
        };
    }
}
