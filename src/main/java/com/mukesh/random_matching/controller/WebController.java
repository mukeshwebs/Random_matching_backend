package com.mukesh.random_matching.controller;

import com.mukesh.random_matching.entity.User;
import com.mukesh.random_matching.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/")
    public String index(Model model) {
        // Add any initial data or attributes if needed
        return "index"; // Serves the index.html template
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        User user = matchService.addUserToPool(name); // Add user to pool
        model.addAttribute("user", user);
        return "index"; // Returns to the index.html page with user data
    }
}
