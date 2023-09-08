package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.RegisterUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.facade.user.UpdateUserFacade;
import co.edu.uco.carpooling.service.usecase.user.ListCustomerUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling/customer")
@Slf4j
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
    public ResponseEntity<Response<CustomerDTO>> createCustomer(@PathVariable CustomerDTO customer) {
        Response<CustomerDTO> response = new Response<>();
        ResponseEntity<Response<CustomerDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            userUseCaseFacade.execute(customer);
            response.addData(customer);
            response.addMessage(Message.createSuccessMessage("The customer has been successfully registered.", "Successful customer registration"));
            log.info(response.toString());

        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Customer"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());

        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors "));
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
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