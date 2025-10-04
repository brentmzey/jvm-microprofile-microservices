package com.example.messaging

import com.example.model.Customer
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.jboss.logging.Logger
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerMessageConsumer {

    private val logger: Logger = Logger.getLogger(CustomerMessageConsumer::class.java)

    @Incoming("customer-creations-in")
    fun receiveCustomerCreationMessage(customer: Customer) {
        logger.infov("Received customer creation message: {0}", customer)
    }
}
