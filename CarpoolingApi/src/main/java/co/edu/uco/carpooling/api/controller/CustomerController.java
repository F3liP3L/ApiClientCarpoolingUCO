package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.DeleteUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.facade.user.RegisterUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.usecase.user.implementation.ListCustomerUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carpooling/customer")
public class CustomerController {

    @Autowired
    private RegisterUserCustomerCaseFacade userUseCaseFacade;
    @Autowired
    private ListCustomerUseCaseImpl customerImplService;
    @Autowired
    private DeleteUserCustomerCaseFacade deleteUserCustomerCaseFacade;

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

    @PutMapping("/update")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO) {

    }
}