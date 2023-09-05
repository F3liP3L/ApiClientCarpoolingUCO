package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.facade.vehicle.RegisterVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.vehicle.FindVehicleUseCaseList;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling/vehicle")
@Slf4j
public class VehicleController {
    @Autowired
    private RegisterVehicleUseCaseFacade facadeCreate;
    @Autowired
    private FindVehicleUseCaseList findVehicleUseCaseList;

    @PostMapping()
    public ResponseEntity<Response<VehicleDTO>> create(@RequestBody VehicleDTO vehicle) {
        Response<VehicleDTO> response = new Response<>();
        ResponseEntity<Response<VehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            facadeCreate.execute(vehicle);
            response.addData(vehicle);
            response.addMessage(Message.createSuccessMessage("The vehicle has been successfully registered.", "Successful vehicle registration"));
            log.info(response.toString());

        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Vehicle"));
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

    @GetMapping()
    public ResponseEntity<Response<List<VehicleDTO>>> findAll() {
        Response<List<VehicleDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            response.addData(findVehicleUseCaseList.execute(null));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
