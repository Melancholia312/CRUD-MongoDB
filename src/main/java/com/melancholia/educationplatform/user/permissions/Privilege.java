package com.melancholia.educationplatform.user.permissions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "privileges")
@Data
@NoArgsConstructor
public class Privilege {

    @Id
    private String id;

    @Indexed
    private String name;

    public Privilege(String name){
        this.name = name;
    }
}
