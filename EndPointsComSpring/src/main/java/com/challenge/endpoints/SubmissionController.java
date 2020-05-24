package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/submission")
public class SubmissionController {

    @Autowired
    private SubmissionRepository submissionRepository;

    @GetMapping
    public ResponseEntity<List<Submission>> findAll(@PathParam("challengeId") Long challengeId,
                                                    @PathParam("accelerationId") Long accelerationId){
        return ResponseEntity
                .ok()
                .body(submissionRepository
                        .findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }

}
