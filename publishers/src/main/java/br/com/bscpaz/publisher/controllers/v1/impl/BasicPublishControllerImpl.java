package br.com.bscpaz.publisher.controllers.v1.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.bscpaz.publisher.controllers.v1.BasicPublishController;
import br.com.bscpaz.publisher.controllers.v1.dtos.ResponseDTO;
import br.com.bscpaz.publisher.utils.ResponseUtil;

@RestController
public class BasicPublishControllerImpl implements BasicPublishController {

    @Override
    public ResponseEntity<ResponseDTO<String>> helloWorldRabbitmq() {
        return ResponseUtil.success("Message published into rabbitmq!");
    }
    
}
