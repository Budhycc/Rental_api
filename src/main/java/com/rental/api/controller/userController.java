package com.rental.api.controller;

// import com.rental.api.model.mobil;
import com.rental.api.model.user;
import com.rental.api.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class userController {
    @Autowired
    private userService service;

    @GetMapping
    public List<user> getAllUser() {
        return service.getAllUser();
    }  

    @PostMapping
    public String createUser(@RequestBody user user) {
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody user userDetails) {
        try {
            user updateUser = service.updateUser(id, userDetails);
            return ResponseEntity.ok(updateUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> getPelangganById(@PathVariable int id) {
        return service.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody user loginRequest) {
        Optional<user> user = service.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok("Welcome, " + user.get().getName() + "!");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody user user) {
        try {
            String savedUser = service.saveUser(user); // Tidak ada error tipe data
            return ResponseEntity.ok(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
    
