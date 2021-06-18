package com.example.kcalculator.controller;

import com.example.kcalculator.service.UserService;
import com.example.kcalculator.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @RequestMapping(value = "/user/signup")
    ResponseEntity<?> insert(@RequestBody User user) {
        return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/user/login")
    ResponseEntity<?> login(@RequestBody String email, @RequestParam String password) {

        return new ResponseEntity<>(userService.login(email, password), HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(value = "/user/delete")
    ResponseEntity<?> delete(@RequestParam String token) {
        return new ResponseEntity<>(userService.deleteUser(token), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/user/getInfo")
    public ResponseEntity<?> getUserInfo(@RequestParam String token) {
        return new ResponseEntity<>(userService.getUserInfo(token), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/user/updateInfo")
    public ResponseEntity<?> modifyUserInfo(@ModelAttribute User user, @RequestParam String token) {
        return new ResponseEntity<>(userService.updateUserInfo(user, token), HttpStatus.OK);
    }


}
