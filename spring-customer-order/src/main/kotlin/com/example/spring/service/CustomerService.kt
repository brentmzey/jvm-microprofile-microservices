package com.example.spring.service

import com.example.spring.messaging.CustomerMessageProducer
import com.example.spring.model.Customer
import com.example.spring.model.Order
import com.example.spring.repository.CustomerRepository
import com.example.spring.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository,
    private val customerMessageProducer: CustomerMessageProducer
) {

    fun getAllCustomers(): List<Customer> = customerRepository.findAll()

    fun getCustomerById(id: Long): Customer? = customerRepository.findById(id).orElse(null)

    @Transactional
    fun createCustomer(customer: Customer): Customer {
        val newCustomer = customerRepository.save(customer)
        customerMessageProducer.sendCustomerCreationMessage(newCustomer)
        return newCustomer
    }

    fun getOrdersForCustomer(customerId: Long): List<Order> = orderRepository.findByCustomerId(customerId)

    @Transactional
    fun createOrder(order: Order): Order = orderRepository.save(order)
}
