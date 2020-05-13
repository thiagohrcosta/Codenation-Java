package com.challenge.repository;

import com.challenge.entity.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository {

    @Query("FROM Candidate " +
            "WHERE c.id.user.id = :userId " +
            "AND c.id.company.id = :companyId " +
            "AND c.id.acceleration.id = :accelerationId")
    Optional<Candidate> findByUserIdCompanyIdAccelerationId(Long userId, Long companyId, Long accelerationId);

    @Query("FROM Candidate c " +
            "WHERE c.id.company.id = :companyId")
    List<Candidate> findByCompanyId(Long companyId);

    @Query("FROM Candidate c " +
            "WHERE c.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(Long accelerationId);
}
