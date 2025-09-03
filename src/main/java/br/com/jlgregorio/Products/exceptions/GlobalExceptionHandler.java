package br.com.jlgregorio.Products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomExceptionResponse> handleAllExceptions(Exception e,
                                                                             WebRequest request){
        CustomExceptionResponse response = new CustomExceptionResponse(new Date(), e.getMessage(),
                request.getDescription(true));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<CustomExceptionResponse> handleResourceNotFoundException(
            ResourceNotFoundException e, WebRequest request
    ){
        CustomExceptionResponse response = new CustomExceptionResponse(new Date(), e.getMessage(),
                request.getDescription(true));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
