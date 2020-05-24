package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping(value = "/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<Candidate> findById(@PathVariable("userId") Long userId,
                                              @PathVariable("companyId") Long companyId,
                                              @PathVariable("accelerationId") Long accelerationId){
        return ResponseEntity.ok().body(candidateService.findById(
                userId,
                companyId,
                accelerationId)
                .orElse(new Candidate()));
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<List<Candidate>> findCompanyId(@RequestParam("companyId") Long companyId){
        return ResponseEntity
                .ok()
                .body(candidateService
                        .findByCompanyId(companyId));
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<Candidate>> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId){
        return ResponseEntity
                .ok()
                .body(candidateService
                        .findByAccelerationId(accelerationId));
    }

}
