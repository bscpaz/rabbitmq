<h1 align="center">RabbitMQ</h1>
<p align="center">This is a POC (proof of concept) to understand better the behavior of RabbitMQ technology.</p>


### Technologies:
* RabbitMQ

#### RabbitMQ Simulator
* http://tryrabbitmq.com/

### Concepts of RabbitMQ

#### Topic Exchange

Topic in RabbitMQ is not similar to Topics in Apache Kafka: the first, once a message is consumed from a instance of a consumer connected to a queue, another instance of the same consumer (plugged at the same queue) cannot read that message anymore. The second, by the other hand, Apache Kafka can save a message (kind of LOG) that diferents instances of a consumer can read the same message.

_Topic exchanges route messages to one or many queues based on matching between a message routing key and the **pattern** that was used to bind a queue to an exchange. The topic exchange type is often used to implement various publish/subscribe pattern variations. Topic exchanges are commonly used for the multicast routing of messages._

#### Fanout Exchange
_A fanout exchange routes messages to all of the queues that are bound to it and the routing key is ignored._

#### Direct Exchange
_A direct exchange delivers messages to queues based on the message routing key. A direct exchange is ideal for the unicast routing of messages._

### Queues

*Quorum queues and streams now replace the original, replicated mirrored classic queue. Mirrored classic queues are now deprecated and scheduled for removal. Use the Migrate your RabbitMQ Mirrored Classic Queues to Quorum Queues guide for migrating RabbitMQ installations that currently use classic mirrored queues.*

*Quorum queues are optimized for set of use cases where data safety is a top priority. This is covered in Motivation. Quorum queues should be considered the default option for a replicated queue type.*

https://www.rabbitmq.com/migrate-mcq-to-qq.html

### Ensuring delivery guarantee
When it comes to ensuring guaranteed delivery, it is crucial not to rely on auto ack = true if we aim to ensure resilience in our systems.

To set the auto ack = false configuration, you need to do it in the consumer's code. For exemple:

```java
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAutoAck(false); // <<<< Desable auto ack
        return factory;
    }
}
```

```java
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "queue_name", containerFactory = "rabbitListenerContainerFactory")
    public void consumeMessage(Message message) {
        try {
            String messageBody = new String(message.getBody(), "UTF-8");
            
            // Some logic
            
            // Manually acknowledge
            message.getMessageProperties().getChannel().basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception ex) {
            // Deal with the exception
            
            // Reject (nack) the mensagem manually with a requeue.
            //message.getMessageProperties().getChannel().basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

            //Or send it to a DLX (Dead Letter Exchange)
            //rabbitTemplate.send("queue_name_dlq", message);
        }
    }
}
```

#### Ports:
- 15672: for user interface (web).
- 5672: for system connections.

#### Virtual Host:
Parameter: RABBITMQ_DEFAULT_VHOST
This name is not related to Virtual Hosts that we usually know, but this is a way to separate contexts on RabbitMQ. 

#### Use the rabbitmq-diagnostics status command
```shell
rabbitmq-diagnostics status
```

It is possible to print effective configuration (user provided values from all configuration files merged into defaults) using the rabbitmq-diagnostics environment command:
```shell
rabbitmq-diagnostics environment
```

#### To generate a hash password
```shell
rabbitmqctl hash_password <your password>
```
