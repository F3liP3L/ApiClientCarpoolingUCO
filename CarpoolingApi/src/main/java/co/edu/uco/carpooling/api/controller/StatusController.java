package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.service.usecase.status.ListStatusUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/carpooling/status")
@Slf4j
public class StatusController {
    @Autowired
    private ListStatusUseCase listStatusUseCase;
    @GetMapping("/{id}")
    public ResponseEntity<Response<List<StatusDTO>>> findStatusById(@PathVariable UUID id) {
        Response<List<StatusDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listStatusUseCase.execute(Optional.of(StatusDTO.create(id))));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
