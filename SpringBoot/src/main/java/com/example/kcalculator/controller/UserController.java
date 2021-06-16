package com.example.kcalculator.controller;

import com.example.kcalculator.UserService;
import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import com.example.kcalculator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    private final UserService userService;

    @PostMapping
    @RequestMapping(value = "/sign_up")
    @ResponseBody
    ResponseEntity<?> insert(@ModelAttribute User user) {
        return new ResponseEntity<>(userService.insert(user),HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/login")
    @ResponseBody
    ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
       return new ResponseEntity<>(userService.login(email,password), HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete_user")
    @ResponseBody
    ResponseEntity<?> delete(@RequestParam String token){
        return new ResponseEntity<>(userService.delete(token),HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @RequestMapping(value = "/my_info")
    @ResponseBody
    public ResponseEntity<?> getMyInfo(@RequestParam String token){
        return new ResponseEntity<>(userService.myInfo(token), HttpStatus.OK);
    }
}
