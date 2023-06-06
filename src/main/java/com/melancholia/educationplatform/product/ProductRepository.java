package com.melancholia.educationplatform.product;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Aggregation(pipeline = {
            "{$group: { _id: '', total: {$sum: $price}}}"
    })
    public double sumPrice();

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg: $price }}}" })
    public double avg();
}
