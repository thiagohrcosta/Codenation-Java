package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long userId){
        return ResponseEntity
                .ok()
                .body(userService
                        .findById(userId)
                        .orElse(null));
    }

    @GetMapping(params = "accelerationName")
    public ResponseEntity<List<User>> findByAccelerationName(@RequestParam("accelerationName") String accelerationName){
        return ResponseEntity
                .ok()
                .body(userService
                        .findByAccelerationName(accelerationName));
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<List<User>> findByCompanyId(@RequestParam("companyId") Long companyId){
        return ResponseEntity
                .ok()
                .body(userService
                        .findByCompanyId(companyId));
    }

}