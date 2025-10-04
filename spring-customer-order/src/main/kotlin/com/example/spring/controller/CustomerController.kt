package com.example.spring.controller

import com.example.spring.model.Customer
import com.example.spring.model.Order
import com.example.spring.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<Customer> {
        val customer = customerService.getCustomerById(id)
        return if (customer != null) {
            ResponseEntity.ok(customer)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: Customer): Customer = customerService.createCustomer(customer)

    @GetMapping("/{id}/orders")
    fun getOrdersForCustomer(@PathVariable id: Long): List<Order> = customerService.getOrdersForCustomer(id)

    @PostMapping("/{id}/orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@PathVariable id: Long, @RequestBody order: Order): Order {
        // In a real app, you'd verify the customer (id) exists first
        val newOrder = order.apply { customerId = id }
        return customerService.createOrder(newOrder)
    }
}
