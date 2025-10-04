package com.example.spring.messaging

import com.example.spring.model.Customer
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class CustomerMessageProducer(private val rabbitTemplate: RabbitTemplate) {

    fun sendCustomerCreationMessage(customer: Customer) {
        rabbitTemplate.convertAndSend("customer-creations", "", customer)
    }
}
