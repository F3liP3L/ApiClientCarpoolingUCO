package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.facade.vehicle.DeleteVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.facade.vehicle.RegisterVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.facade.vehicle.UpdateVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.vehicle.FindVehicleUseCaseList;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonPatch;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling/vehicle")
@Slf4j
public class VehicleController {
    @Autowired
    private RegisterVehicleUseCaseFacade facadeCreate;
    @Autowired
    private DeleteVehicleUseCaseFacade facadeDelete;
    @Autowired
    private UpdateVehicleUseCaseFacade facadeUpdate;
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
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(findVehicleUseCaseList.execute(null));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping()
    public ResponseEntity<Response<VehicleDTO>> delete(@RequestBody VehicleDTO vehicle) {
        Response<VehicleDTO> response = new Response<>();
        ResponseEntity<Response<VehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            facadeDelete.execute(vehicle);
            response.addMessage(Message.createSuccessMessage("The vehicle was successfully removed", "Vehicle successfully removed"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting vehicle"));
            log.warn(response.toString());
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Error"));
            log.error(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @PatchMapping(value = "/{id}", consumes ="application/json-patch+json")
    public ResponseEntity<Response<VehicleDTO>> update(@PathVariable("id") UUID id, @RequestBody JsonPatch vehicle) {
        Response<VehicleDTO> response = new Response<>();
        ResponseEntity<Response<VehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            facadeUpdate.execute(id, vehicle, new VehicleDTO().createPatch());
            response.addData(VehicleDTO.create());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Vehicle updated correctly"));
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}
