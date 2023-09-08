package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.RegisterUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.facade.user.UpdateUserFacade;
import co.edu.uco.carpooling.service.usecase.user.ListCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/carpooling/customer")
public class CustomerController {

    @Autowired
    private RegisterUserCustomerCaseFacade userUseCaseFacade;
    @Autowired
    private ListCustomerUseCase listCustomerUseCase;
    @Autowired
    private DeleteUserUseCaseFacade deleteUserCustomerCaseFacade;
    @Autowired
    private UpdateUserFacade updateUserFacade;

    @GetMapping("/get")
    public List<CustomerDTO> getAllCustomer() {
        return listCustomerUseCase.execute(Optional.of(CustomerDTO.create()));
    }

    @PostMapping("/create/{customer}")
    public void createCustomer(@PathVariable CustomerDTO customer) {
        userUseCaseFacade.execute(customer);
    }

    @DeleteMapping("/delete/{customerDTO}")
    public void deleteCustomer(@PathVariable CustomerDTO customerDTO) {
        deleteUserCustomerCaseFacade.execute(customerDTO);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody CustomerDTO customerDTO) {
        updateUserFacade.execute(id,customerDTO);
    }
}