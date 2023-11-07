package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.service.facade.driver.DeleteDriverUseCaseFacade;
import co.edu.uco.carpooling.service.facade.driver.RegisterDriverUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.driver.ListDriverUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling/driver")
@Slf4j
public class DriverController {

    @Autowired
    private RegisterDriverUseCaseFacade registerDriverUseCaseFacade;
    @Autowired
    private ListDriverUseCase listDriverUseCase;
    @Autowired
    private DeleteDriverUseCaseFacade deleteDriverUseCaseFacade;

    @GetMapping()
    public ResponseEntity<Response<List<DriverDTO>>> getAllCustomer() {
        Response<List<DriverDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listDriverUseCase.execute(Optional.of(DriverDTO.create())));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping()
    ResponseEntity<Response<DriverDTO>> registerDriver(@RequestBody DriverDTO driver) {
        Response<DriverDTO> response = new Response<>();
        ResponseEntity<Response<DriverDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            registerDriverUseCaseFacade.execute(driver);
            response.addData(driver);
            response.addMessage(Message.createSuccessMessage("The Driver has been successfully registered.", "Successful Driver registration"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Driver"));
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
    public ResponseEntity<Response<DriverDTO>> deleteDriver(@RequestBody DriverDTO driver) {
        Response<DriverDTO> response = new Response<>();
        ResponseEntity<Response<DriverDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            deleteDriverUseCaseFacade.execute(driver);
            response.addMessage(Message.createSuccessMessage("The Driver was successfully removed", "Driver successfully removed"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting Driver"));
            log.warn(response.toString());
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Error"));
            log.error(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}
