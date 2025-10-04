package com.example.repository;

import com.example.model.Order;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

@ApplicationScoped
public class OrderRepository implements PanacheMongoRepository<Order> {
}
