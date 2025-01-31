package com.rental.api.service;

// import com.rental.api.model.mobil;
import com.rental.api.model.user;
import com.rental.api.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    private userRepository repository;

    public List<user> getAllUser() {
        return repository.findAll();
    }

    public String saveUser(user user) {
        try {
            repository.save(user);
            return "User berhasil ditambahkan!";
        } catch (DataIntegrityViolationException e) {
            return "Error: Username sudah digunakan!";
        }
    }

    public user updateUser(int id, user userDetails) {
        return repository.findById(id).map(existingUser -> {
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setName(userDetails.getName());
            existingUser.setPassword(userDetails.getPassword());
            return repository.save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User dengan ID " + id + " tidak ditemukan"));
    }

    public Optional<user> getUserById(int id) {
        return repository.findById(id);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public Optional<user> login(String username, String password) {
        return repository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }

}
