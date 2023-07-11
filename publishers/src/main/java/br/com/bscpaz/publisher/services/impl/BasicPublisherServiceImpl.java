package br.com.bscpaz.publisher.services.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bscpaz.publisher.configurations.RabbitmqConfig;
import br.com.bscpaz.publisher.services.BasicPublisherService;

@Service
public class BasicPublisherServiceImpl implements BasicPublisherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String helloWorldRabbitmq() {
        String helloWorld = "Hello World";
        Message message = new Message(helloWorld.getBytes());

        rabbitTemplate.send(
            RabbitmqConfig.JUSTICE_V1_DOCS_EXCHANGE, 
            RabbitmqConfig.JUSTICE_V1_DOCS_ROUTING_KEY + "1",
            message);

        return "Message has been sent to RabbitMQ!";
    }
}
