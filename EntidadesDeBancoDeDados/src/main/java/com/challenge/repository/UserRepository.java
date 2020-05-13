package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT c.id.user " +
            "FROM Candidate c " +
            "WHERE c.id.acceleration.name " +
            "LIKE :name")

    List<User>findByAccelerationName(String name);

    @Query("SELECT c.id.user " +
            "FROM Candidate c " +
            "WHERE c.id.company.id = :companyId")
    List<User>findByCompanyId(Long companyId);
}
