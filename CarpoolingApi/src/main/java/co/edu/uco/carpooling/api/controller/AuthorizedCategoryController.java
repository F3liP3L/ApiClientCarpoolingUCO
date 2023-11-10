package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.dto.AuthorizedCategoryDTO;
import co.edu.uco.carpooling.service.usecase.authorizedcategory.ListAuthorizedCategoryAllUseCase;
import co.edu.uco.carpooling.service.usecase.authorizedcategory.ListAuthorizedCategoryUseCase;
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
@RequestMapping("api/v1/carpooling/authorizedcategory")
@Slf4j
public class AuthorizedCategoryController {
    @Autowired
    private ListAuthorizedCategoryUseCase listAuthorizedCategoryUseCase;
    @Autowired
    private ListAuthorizedCategoryAllUseCase listAuthorizedCategoryAllUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Response<List<AuthorizedCategoryDTO>>> getOneAuthorizedCategory(@PathVariable("id") UUID id) {
        Response<List<AuthorizedCategoryDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listAuthorizedCategoryUseCase.execute(Optional.of(AuthorizedCategoryDTO.create(id))));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping()
    public ResponseEntity<Response<List<AuthorizedCategoryDTO>>> getAllAuthorizedCategory() {
        Response<List<AuthorizedCategoryDTO>> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        response.setData(new ArrayList<>());
        try {
            response.addData(listAuthorizedCategoryAllUseCase.execute(Optional.of(AuthorizedCategoryDTO.createNewAuthorizedCategory())));
        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected error"));
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
