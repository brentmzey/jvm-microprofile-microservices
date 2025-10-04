package com.example.spring.config

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun customerCreationsQueue(): Queue {
        return Queue("customer-creations", false)
    }
}
