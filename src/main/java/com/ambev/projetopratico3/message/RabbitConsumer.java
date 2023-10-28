package com.ambev.projetopratico3.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//Aqui as mensagens são consumidas da fila e o @RabbitListener garante o ack automárico evitando o acúmulo

@Component
public class RabbitConsumer {
    private final static String QUEUE_NAME = "cadastroProdutos";

    @RabbitListener(queues = "cadastroProdutos")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: '" + message + "'");
    }
}


