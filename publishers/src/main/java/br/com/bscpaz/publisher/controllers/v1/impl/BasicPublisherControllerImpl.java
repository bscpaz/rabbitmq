package br.com.bscpaz.publisher.controllers.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.bscpaz.publisher.controllers.dtos.ResponseDTO;
import br.com.bscpaz.publisher.controllers.utils.ResponseUtil;
import br.com.bscpaz.publisher.controllers.v1.BasicPublisherController;
import br.com.bscpaz.publisher.services.BasicPublisherService;

@RestController
public class BasicPublisherControllerImpl implements BasicPublisherController {

    @Autowired
    private BasicPublisherService basicPublisherController;

    @Override
    public ResponseEntity<ResponseDTO<String>> helloWorldRabbitmq() {
        try {
            String message = basicPublisherController.helloWorldRabbitmq();
            return ResponseUtil.success(message, null);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e.getMessage(), "Sorry, something went wrong.");
        }
    }
}
