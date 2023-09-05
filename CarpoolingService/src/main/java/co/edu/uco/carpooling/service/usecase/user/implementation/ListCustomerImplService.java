package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.repository.CustomerRepository;
import co.edu.uco.carpooling.service.mapper.entityassembler.impl.CustomerEntityAssembler;
import co.edu.uco.carpooling.service.usecase.user.ListCustomerCustomerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListCustomerImplService implements ListCustomerCustomerCase {
    @Autowired
    private CustomerEntityAssembler entityAssembler;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> execute(Optional<CustomerDTO> dto) {
        return customerRepository.findAll().stream()
                .map(customerEntity -> entityAssembler.assembleDTO(customerEntity)).toList();
    }
}