package ru.novolotsky.clientregister.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.novolotsky.clientregister.to.Response;

@RestControllerAdvice
public class JacksonExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleConverterErrors(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new Response(2), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity handleConverterErrors(JsonProcessingException e) {
        return new ResponseEntity<>(new Response(2), HttpStatus.BAD_REQUEST);
    }
}
