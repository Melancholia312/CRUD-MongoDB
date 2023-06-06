package com.melancholia.educationplatform.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@Document(collection = "products")
@Data
public class Product {

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private double price;

    private Date creationDate;

}
