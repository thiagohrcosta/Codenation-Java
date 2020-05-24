package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeController {

    @Autowired
    public ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> findAll( @PathParam("accelerationId") Long accelerationId,
                                                    @PathParam("userId") Long userId){
        return ResponseEntity
                .ok()
                .body(challengeService
                        .findByAccelerationIdAndUserId(accelerationId, userId));
    }
}
