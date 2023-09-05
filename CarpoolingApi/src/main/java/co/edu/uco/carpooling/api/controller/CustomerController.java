package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.adapter.repository.CustomerRepository;
import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.RegisterUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.UpdateUserFacade;
import co.edu.uco.carpooling.service.usecase.user.implementation.ListCustomerUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/carpooling/customer")
public class CustomerController {

    @Autowired
    private RegisterUserUseCaseFacade userUseCaseFacade;
    @Autowired
    private ListCustomerUseCaseImpl customerImplService;
    @Autowired
    private DeleteUserUseCaseFacade deleteUserCustomerCaseFacade;
    @Autowired
    private UpdateUserFacade updateUserFacade;

    @GetMapping("/")
    public List<CustomerDTO> sayHello() {
        return customerImplService.execute(Optional.of(CustomerDTO.create()));
        }

    @PostMapping("/create/{customer}")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        userUseCaseFacade.execute(customerDTO);
    }
    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody CustomerDTO customerDTO) {
        deleteUserCustomerCaseFacade.execute(customerDTO);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody CustomerDTO customerDTO) {
        updateUserFacade.execute(id,customerDTO);
    }
}