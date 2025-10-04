package com.example.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCustomerOrderApplication

fun main(args: Array<String>) {
	runApplication<SpringCustomerOrderApplication>(*args)
}
