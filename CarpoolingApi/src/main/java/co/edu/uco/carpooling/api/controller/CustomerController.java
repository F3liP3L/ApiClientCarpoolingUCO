package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.RegisterUserUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.user.implementation.ListCustomerImplService;
import co.edu.uco.crosscutting.util.UtilText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carpooling/customer")
public class CustomerController {

    @Autowired
    private RegisterUserUseCaseFacade userUseCaseFacade;
    @Autowired
    private ListCustomerImplService customerImplService;

    @GetMapping("/")
    public List<CustomerDTO> sayHello() {
        return customerImplService.execute(Optional.of(CustomerDTO.create()));
        }

    @PostMapping("/create/{customer}")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        userUseCaseFacade.execute(customerDTO);
    }
}