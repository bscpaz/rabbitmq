package br.com.bscpaz.publisher.controllers.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bscpaz.publisher.base.ApiVersions;
import br.com.bscpaz.publisher.controllers.dtos.ResponseDTO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RequestMapping(path = ApiVersions.V1 + BasicPublisherController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public interface BasicPublisherController {

    public final static String PATH = "/hello-world";

    @GetMapping
    ResponseEntity<ResponseDTO<String>> helloWorldRabbitmq();

}
