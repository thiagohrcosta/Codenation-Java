package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .body(companyService
                        .findById(id)
                        .orElse(null));
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<Company>> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId){
        return ResponseEntity
                .ok()
                .body(companyService
                        .findByAccelerationId(accelerationId));
    }

    @GetMapping(params = "userId")
    public ResponseEntity<List<Company>> findUserById(@RequestParam("userId") Long userId){
        return ResponseEntity
                .ok()
                .body(companyService
                        .findByUserId(userId));
    }
}
