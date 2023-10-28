package com.ambev.projetopratico3.message;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @Bean
    public Queue queue(){
        return new Queue("cadastroProdutos");
    }

}