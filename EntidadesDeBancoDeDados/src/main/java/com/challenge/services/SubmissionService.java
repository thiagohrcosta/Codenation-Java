package com.challenge.services;

import com.challenge.entity.Submission;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import java.math.BigDecimal;
import java.util.List;

public class SubmissionService implements SubmissionServiceInterface {

    private SubmissionService submissionService;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return submissionService.findHigherScoreByChallengeId(challengeId);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return submissionService.save(object);
    }
}
