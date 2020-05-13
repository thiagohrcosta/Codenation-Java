package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT distinct c " +
            "FROM Company c " +
            "JOIN c.candidates n " +
            "WHERE n.id.user.id = :userId")
    List<Company> findByUserId(Long userId);

    @Query("SELECT distinct c " +
            "FROM Company c " +
            "JOIN c.candidates n " +
            "WHERE n.id.acceleration.id = :accelerationId")
    List<Company> findAccelerationById(Long accelerationId);
}
