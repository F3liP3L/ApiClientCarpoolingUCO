package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.dto.DriverDTO;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class ExceptionHandlingController {



        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Response<String>> handleException(MethodArgumentNotValidException e){
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new Response<>(), httpStatus);

        }

        @ExceptionHandler(JsonMappingException.class)
        public
        ResponseEntity<Response<String>>handleJsonMappingException(JsonMappingException e){
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new Response<>(), httpStatus);
        }
}
