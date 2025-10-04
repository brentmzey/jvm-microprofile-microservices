package com.example.messaging

import com.example.model.Customer
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerMessageProducer {

    @Channel("customer-creations")
    lateinit var emitter: Emitter<Customer>

    fun sendCustomerCreationMessage(customer: Customer) {
        emitter.send(customer)
    }
}
