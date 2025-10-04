package com.example.spring.messaging

import com.example.spring.model.Customer
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class CustomerMessageConsumer {

    private val logger = LoggerFactory.getLogger(CustomerMessageConsumer::class.java)

    @RabbitListener(queues = ["customer-creations"])
    fun receiveCustomerCreationMessage(customer: Customer) {
        logger.info("Received customer creation message: {}", customer)
    }
}
