package br.com.bscpaz.publisher.controllers.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bscpaz.publisher.controllers.dtos.ResponseDTO;

public class ResponseUtil {
    
    public static <T> ResponseEntity<ResponseDTO<T>> success(T payload) {
        ResponseDTO<T> dto = new ResponseDTO<T>(true, payload);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> success(String message, T payload) {
        ResponseDTO<T> dto = new ResponseDTO<T>(true, message, payload);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> badRequest(T payload, String message) {
        ResponseDTO<T> dto = new ResponseDTO<T>(false, message, payload);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> internalServerError(T payload, String message) {
        ResponseDTO<T> dto = new ResponseDTO<T>(false, message, payload);
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}