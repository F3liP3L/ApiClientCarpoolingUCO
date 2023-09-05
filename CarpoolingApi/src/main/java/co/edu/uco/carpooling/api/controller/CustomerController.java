package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.RegisterUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.usecase.user.ListCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carpooling/customer")
public class CustomerController {

    @Autowired
    private RegisterUserCustomerCaseFacade userUseCaseFacade;
    @Autowired
    private ListCustomerUseCase listCustomerUseCase;
    @Autowired
    private DeleteUserUseCaseFacade deleteUserCustomerCaseFacade;

    @PostMapping("/create")
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