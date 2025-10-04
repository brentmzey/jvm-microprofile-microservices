package com.example.spring.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate

@Document(collection = "orders")
data class Order(
    @Id
    var id: String? = null,
    var customerId: Long? = null,
    var description: String? = null,
    var total: BigDecimal? = null,
    var date: LocalDate? = null
)
