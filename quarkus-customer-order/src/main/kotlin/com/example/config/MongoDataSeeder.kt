package com.example.config

import com.example.model.Order
import com.example.repository.OrderRepository
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import jakarta.inject.Inject
import java.math.BigDecimal
import java.time.LocalDate

@ApplicationScoped
class MongoDataSeeder {

    @Inject
    lateinit var orderRepository: OrderRepository

    fun onStart(@Observes ev: StartupEvent) {
        if (orderRepository.count() == 0L) {
            println("Seeding MongoDB with sample orders for Quarkus...")
            orderRepository.persist(
                listOf(
                    Order(
                        id = null,
                        customerId = 1L,
                        description = "Quarkus Sample Order 1",
                        total = BigDecimal("99.99"),
                        date = LocalDate.now()
                    ),
                    Order(
                        id = null,
                        customerId = 2L,
                        description = "Quarkus Sample Order 2",
                        total = BigDecimal("145.50"),
                        date = LocalDate.now().minusDays(2)
                    )
                )
            )
            println("Quarkus MongoDB seeding complete.")
        }
    }
}
