package com.example.resource

import com.example.model.Customer
import com.example.model.Order
import com.example.service.CustomerService
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CustomerResource {

    @Inject
    lateinit var customerService: CustomerService

    @GET
    fun getAllCustomers(): List<Customer> = customerService.getAllCustomers()

    @GET
    @Path("/{id}")
    fun getCustomerById(id: Long): Response {
        val customer = customerService.getCustomerById(id)
        return if (customer != null) {
            Response.ok(customer).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @POST
    fun createCustomer(customer: Customer): Response {
        val newCustomer = customerService.createCustomer(customer)
        return Response.status(Response.Status.CREATED).entity(newCustomer).build()
    }

    @GET
    @Path("/{id}/orders")
    fun getOrdersForCustomer(id: Long): List<Order> = customerService.getOrdersForCustomer(id)
    
    @POST
    @Path("/{id}/orders")
    fun createOrder(id: Long, order: Order): Response {
        // In a real app, you'd verify the customer (id) exists first
        order.customerId = id
        customerService.createOrder(order)
        return Response.status(Response.Status.CREATED).entity(order).build()
    }
}
