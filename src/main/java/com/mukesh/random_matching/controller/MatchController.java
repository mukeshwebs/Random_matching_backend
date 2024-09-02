package com.mukesh.random_matching.controller;

import com.mukesh.random_matching.entity.User;
import com.mukesh.random_matching.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/addUser")
    public User addUser(@RequestParam String name) {
        return matchService.addUserToPool(name);
    }

    @GetMapping("/findMatch/{userId}")
    public Optional<User> findMatch(@PathVariable Long userId) {
        return matchService.findMatch(userId);
    }
}
