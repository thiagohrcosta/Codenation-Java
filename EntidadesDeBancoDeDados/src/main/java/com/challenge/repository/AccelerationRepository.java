package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository {

    @Query("SELECT a " +
            "FROM acceleration a " +
            "JOIN a.candidates c " +
            "WHERE c.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(Long companyId);
}
