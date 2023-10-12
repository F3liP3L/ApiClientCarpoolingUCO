package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.facade.driverpervehicle.DeleteDriverPerVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.facade.driverpervehicle.RegisterDriverPerVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.facade.driverpervehicle.UpdateDriverPerVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.usecase.driverpervehicle.ListDriverPerVehicleUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonPatch;
import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@Slf4j
@RestController
@RequestMapping("api/v1/carpooling/driverpervehicle")
public class DriverPerVehicleController {
    @Autowired
    private RegisterDriverPerVehicleUseCaseFacade registerDriverPerVehicleUseCaseFacade;
    @Autowired
    private DeleteDriverPerVehicleUseCaseFacade deleteDriverPerVehicleUseCaseFacade;
    @Autowired
    private UpdateDriverPerVehicleUseCaseFacade updateDriverPerVehicleUseCaseFacade;
    @Autowired
    private ListDriverPerVehicleUseCase listDriverPerVehicleUseCase;

    @GetMapping
    public ResponseEntity<Response<List<DriverPerVehicleDTO>>> findAll(@RequestBody DriverPerVehicleDTO driverPerVehicleDTO) {
        Response<List<DriverPerVehicleDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listDriverPerVehicleUseCase.execute(Optional.of(driverPerVehicleDTO)));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error, try to " +
                    "get all driver per vehicle"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping
    public ResponseEntity<Response<DriverPerVehicleDTO>> create(@RequestBody DriverPerVehicleDTO driverPerVehicleDTO) {
        Response<DriverPerVehicleDTO> response = new Response<>();
        ResponseEntity<Response<DriverPerVehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            registerDriverPerVehicleUseCaseFacade.execute(driverPerVehicleDTO);
            response.addData(driverPerVehicleDTO);
            response.addMessage(Message.createSuccessMessage("The driver per vehicle has been successfully registered.", "Successful driver per vehicle registration"));
            log.info(response.toString());

        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a driver per vehicle"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());

        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors"));
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @DeleteMapping
    public ResponseEntity<Response<DriverPerVehicleDTO>> delete(@RequestBody DriverPerVehicleDTO driverPerVehicleDTO) {
        Response<DriverPerVehicleDTO> response = new Response<>();
        ResponseEntity<Response<DriverPerVehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            deleteDriverPerVehicleUseCaseFacade.execute(driverPerVehicleDTO);
            response.addMessage(Message.createSuccessMessage("The driver per vehicle was successfully removed", "Driver per vehicle successfully removed"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.NOT_FOUND;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error deleting driver per vehicle"));
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
    public ResponseEntity<Response<DriverPerVehicleDTO>> update(@PathVariable("id") UUID id, @RequestBody JsonPatch driverPerVehicle) {
        Response<DriverPerVehicleDTO> response = new Response<>();
        ResponseEntity<Response<DriverPerVehicleDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            DriverPerVehicleDTO dto = DriverPerVehicleDTO.create();
            updateDriverPerVehicleUseCaseFacade.execute(id,driverPerVehicle,dto);
            response.addData(dto);
            response.addMessage(Message.createSuccessMessage("Your driver per vehicle data has been successfully updated."
                    , "Driver per vehicle successfully update."));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Your driver per vehicle could not be upgraded."));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Error"));
            log.error(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }
}
