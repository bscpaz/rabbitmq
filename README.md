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


