package com.melancholia.educationplatform.user.permissions;


import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
@Repository
public interface PrivilegeRepository extends MongoRepository<Privilege, String> {
}
