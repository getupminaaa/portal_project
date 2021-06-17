package com.example.kcalculator.controller;

import com.example.kcalculator.service.UserService;
import com.example.kcalculator.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @RequestMapping(value = "/sign_up")
    @ResponseBody
    ResponseEntity<?> insert(@ModelAttribute User user) {
        return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/login")
    @ResponseBody
    ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        return new ResponseEntity<>(userService.login(email, password), HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete")
    @ResponseBody
    ResponseEntity<?> delete(@RequestParam String token) {
        return new ResponseEntity<>(userService.deleteUser(token), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/get_userinfo")
    @ResponseBody
    public ResponseEntity<?> getUserInfo(@RequestParam String token) {
        return new ResponseEntity<>(userService.getUserInfo(token), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/update_userinfo")
    @ResponseBody
    public ResponseEntity<?> modifyUserInfo(@ModelAttribute User user, @RequestParam String token) {
        return new ResponseEntity<>(userService.updateUserInfo(user, token), HttpStatus.OK);
    }


}
