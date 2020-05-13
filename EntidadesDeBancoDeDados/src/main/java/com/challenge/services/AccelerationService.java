package com.challenge.services;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

import java.util.List;
import java.util.Optional;

public class AccelerationService implements AccelerationServiceInterface {

    private AccelerationRepository accelerationRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return (Acceleration) accelerationRepository.save(object);
    }
}
