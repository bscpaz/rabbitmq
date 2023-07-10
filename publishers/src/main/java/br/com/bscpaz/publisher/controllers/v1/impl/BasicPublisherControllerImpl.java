package br.com.bscpaz.publisher.controllers.v1.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.bscpaz.publisher.controllers.dtos.ResponseDTO;
import br.com.bscpaz.publisher.controllers.utils.ResponseUtil;
import br.com.bscpaz.publisher.controllers.v1.BasicPublisherController;

@RestController
public class BasicPublisherControllerImpl implements BasicPublisherController {

    @Override
    public ResponseEntity<ResponseDTO<String>> helloWorldRabbitmq() {
        return ResponseUtil.success("Message published into rabbitmq!");
    }
    
}
