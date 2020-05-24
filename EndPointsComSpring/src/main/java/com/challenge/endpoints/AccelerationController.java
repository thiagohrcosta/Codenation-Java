package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationController {

    @Autowired
    public AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable("id") Long id){
        return ResponseEntity
                .ok()
                .body(accelerationService
                        .findById(id)
                        .orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Acceleration>> findByCompanyId(@PathParam("companyId") Long companyId){
        return ResponseEntity
                .ok()
                .body(accelerationService
                        .findByCompanyId(companyId));
    }
}
