package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.PatchUserUseCaseFacade;
import co.edu.uco.carpooling.service.facade.user.RegisterUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.facade.user.UpdateUserFacade;
import co.edu.uco.carpooling.service.usecase.user.ListCustomerUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonPatch;
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
    @Autowired
    private PatchUserUseCaseFacade patchUserUseCaseFacade;

    @GetMapping()
    public ResponseEntity<Response<List<CustomerDTO>>> getAllCustomer() {
        Response<List<CustomerDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listCustomerUseCase.execute(Optional.of(CustomerDTO.create())));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping()
    public ResponseEntity<Response<CustomerDTO>> createCustomer(@RequestBody CustomerDTO customer) {
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

    @DeleteMapping()
    public ResponseEntity<Response<CustomerDTO>> delete(@RequestBody CustomerDTO customerDTO) {
        Response<CustomerDTO> response = new Response<>();
        ResponseEntity<Response<CustomerDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            deleteUserCustomerCaseFacade.execute(customerDTO);
            response.addMessage(Message.createSuccessMessage("The Customer was successfully removed", "Customer successfully removed"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting Customer"));
            log.warn(response.toString());
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Error"));
            log.error(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response<CustomerDTO>> updateCustomer(@PathVariable UUID id, @RequestBody CustomerDTO customerDTO) {
        Response<CustomerDTO> response = new Response<>();
        ResponseEntity<Response<CustomerDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            updateUserFacade.execute(id,customerDTO);
            response.addData(customerDTO);
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Customer can not update"));
        }
        responseEntity = new ResponseEntity<>(response,httpStatus);
        return responseEntity;
    }

    @PatchMapping(value = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Response<CustomerDTO>> update(@PathVariable("id") UUID id, @RequestBody JsonPatch customer) {
        Response<CustomerDTO> response = new Response<>();
        ResponseEntity<Response<CustomerDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            patchUserUseCaseFacade.execute(id, customer);
            response.addMessage(Message.createSuccessMessage("The user has updated satisfactory", "Update Sucessfull"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "user updated with patch correctly"));
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}