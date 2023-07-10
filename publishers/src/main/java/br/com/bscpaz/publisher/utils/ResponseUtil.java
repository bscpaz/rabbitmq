package br.com.bscpaz.publisher.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.bscpaz.publisher.controllers.v1.dtos.ResponseDTO;

public class ResponseUtil {
    
    public static <T> ResponseEntity<ResponseDTO<T>> success(T conteudo) {
        ResponseDTO<T> dto = new ResponseDTO<T>(true, conteudo);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> badRequest(T conteudo, String mensage) {
        ResponseDTO<T> dto = new ResponseDTO<T>(false, mensage, conteudo);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}