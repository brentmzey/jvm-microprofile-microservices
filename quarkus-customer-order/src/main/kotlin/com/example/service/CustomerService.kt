package com.example.service

import com.example.model.Customer
import com.example.model.Order
import com.example.repository.CustomerRepository
import com.example.repository.OrderRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class CustomerService {

    @Inject
    lateinit var customerRepository: CustomerRepository

    @Inject
    lateinit var orderRepository: OrderRepository

    fun getAllCustomers(): List<Customer> = customerRepository.listAll()

    fun getCustomerById(id: Long): Customer? = customerRepository.findById(id)

    @Transactional
    fun createCustomer(customer: Customer): Customer {
        customerRepository.persist(customer)
        return customer
    }

    fun getOrdersForCustomer(customerId: Long): List<Order> = orderRepository.find("customerId", customerId).list()

    @Transactional
    fun createOrder(order: Order): Order {
        orderRepository.persist(order)
        return order
    }
}
