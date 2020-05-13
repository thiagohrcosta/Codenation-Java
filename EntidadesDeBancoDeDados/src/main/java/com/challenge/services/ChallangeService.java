package com.challenge.services;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import java.util.List;

public class ChallangeService implements ChallengeServiceInterface {

    private ChallangeService challangeService;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challangeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @Override
    public Challenge save(Challenge object) {
        return challangeService.save(object);
    }
}
