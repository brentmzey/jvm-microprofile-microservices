package com.example.spring.service

import com.example.spring.model.Customer
import com.example.spring.model.Order
import com.example.spring.repository.CustomerRepository
import com.example.spring.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository
) {

    fun getAllCustomers(): List<Customer> = customerRepository.findAll()

    fun getCustomerById(id: Long): Customer? = customerRepository.findById(id).orElse(null)

    @Transactional
    fun createCustomer(customer: Customer): Customer = customerRepository.save(customer)

    fun getOrdersForCustomer(customerId: Long): List<Order> = orderRepository.findByCustomerId(customerId)

    @Transactional
    fun createOrder(order: Order): Order = orderRepository.save(order)
}
