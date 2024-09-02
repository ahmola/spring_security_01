package com.example.securityprac01.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
@RestController
public class SecurityController {

    private final SecurityService securityService;

    @GetMapping("/all")
    public ResponseEntity<List<SecurityUser>> showAll(){
        return new ResponseEntity<>(securityService.all(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDetails> createUser(@RequestBody SecurityUserDTO securityUserDTO){
        return new ResponseEntity<>(securityService.createUser(securityUserDTO), HttpStatus.CREATED);
    }
}
