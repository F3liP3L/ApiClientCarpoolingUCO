package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.dto.requestroute.RouteAvailableDTO;
import co.edu.uco.carpooling.dto.requestroute.RouteRequestDTO;
import co.edu.uco.carpooling.service.facade.route.RouteSaveUseCaseFacade;
import co.edu.uco.carpooling.service.facade.routerequest.CreateRouteUseCaseFacade;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import co.edu.uco.carpooling.service.usecase.route.FindRouteCreateUseCase;
import co.edu.uco.carpooling.service.usecase.route.RouteActiveUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling/route")
@Slf4j
public class RouteController {
    @Autowired
    private CreateRouteUseCaseFacade facadeCreate;
    @Autowired
    private FindRouteCreateUseCase routeCreateUseCase;
    @Autowired
    private RouteSaveUseCaseFacade routeSaveUseCaseFacade;
    @Autowired
    private RouteActiveUseCase routeActiveUseCase;
    @Autowired
    private RouteRepository repository;

    @PostMapping()
    public ResponseEntity<Response<RouteRequestDTO>> create(@RequestBody RouteRequestDTO route){
        Response<RouteRequestDTO> response = new Response<>();
        ResponseEntity<Response<RouteRequestDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            facadeCreate.execute(route);
            response.addData(route);
            response.addMessage(Message.createSuccessMessage("The route has been successfully registered.", "successful route registration"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Route"));
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

    @PostMapping("/save")
    public ResponseEntity<Response<RouteDTO>> save(@RequestBody RouteDTO route){
        Response<RouteDTO> response = new Response<>();
        ResponseEntity<Response<RouteDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            routeSaveUseCaseFacade.execute(route);
            response.addMessage(Message.createSuccessMessage("The route has been successfully registered.", "successful route registration"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Saving Route"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected Errors"));
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<RouteDTO>> findRouteCreate(@PathVariable UUID id) {
        Response<RouteDTO> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(routeCreateUseCase.execute(id));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping("/active")
    public ResponseEntity<List<RouteAvailableDTO>> findActiveRoute() {
        List<RouteAvailableDTO> routes = new ArrayList<>();
        try {
            routes = routeActiveUseCase.execute(Optional.of(RouteAvailableDTO.build()));
        } catch (GeneralException exception) {
            log.error(exception.getUserMessage());
        }
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
}
