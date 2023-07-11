package br.com.bscpaz.publisher.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    @JsonProperty(value = "success")
    private boolean isSuccess;

    private String message;

    private T payload;

    public ResponseDTO() {
    }

    public ResponseDTO(boolean isSuccess, T t) {
        this.isSuccess = isSuccess;
        this.payload = t;
    }

    public ResponseDTO(boolean isSuccess, String message, T t) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.payload = t;
    }
}
