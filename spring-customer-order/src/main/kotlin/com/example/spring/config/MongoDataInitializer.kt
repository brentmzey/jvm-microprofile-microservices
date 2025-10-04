package com.example.spring.config

import com.example.spring.model.Order
import com.example.spring.repository.OrderRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate

@Component
class MongoDataInitializer(private val orderRepository: OrderRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (orderRepository.count() == 0L) {
            println("Seeding MongoDB with sample orders...")
            orderRepository.saveAll(
                listOf(
                    Order(
                        id = null,
                        customerId = 1L,
                        description = "Sample Order 1",
                        total = BigDecimal("120.50"),
                        date = LocalDate.now()
                    ),
                    Order(
                        id = null,
                        customerId = 1L,
                        description = "Sample Order 2",
                        total = BigDecimal("75.00"),
                        date = LocalDate.now().minusDays(1)
                    )
                )
            )
            println("MongoDB seeding complete.")
        }
    }
}
