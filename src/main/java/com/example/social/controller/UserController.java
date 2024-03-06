package com.example.social.controller;

import com.example.social.entity.User;
import com.example.social.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Find all Users", tags = "User")
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @Operation(summary = "Find User by id", tags = "User")
    @GetMapping("/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id){
        User user = userService.findById(id);

        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update a User", tags = "User")
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
        return ResponseEntity.ok(userService.update(id, user));
    }

    @Operation(summary = "Save a new User", tags = "User")
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @Operation(summary = "Delete a User", tags = "User")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
