package com.example.model

import io.quarkus.mongodb.panache.common.MongoEntity
import org.bson.types.ObjectId
import java.math.BigDecimal
import java.time.LocalDate

@MongoEntity(collection = "orders")
data class Order(
    var id: ObjectId? = null,
    var customerId: Long? = null,
    var description: String? = null,
    var total: BigDecimal? = null,
    var date: LocalDate? = null
)
