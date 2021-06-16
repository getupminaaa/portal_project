package com.example.kcalculator.controller;

import com.example.kcalculator.UserRepository;
import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @RequestMapping(value = "/api/sign_up",method = {RequestMethod.POST})
    @ResponseBody
    public User insert(@ModelAttribute User user) {
        return userRepository.save(
               user
        );
    }

    @RequestMapping(value = "/api/login",method = {RequestMethod.POST})
    @ResponseBody
    public Response login(@RequestParam String email, @RequestParam String password, @ModelAttribute Response response) {
        User result;
        result = userRepository.findByEmailAndPassword(email, password);
        if(result == null) {
            response.setResultCode(-1);
            response.setDesc("로그인 실패");
        }else {
            response.setResultCode(200);
            response.setDesc("로그인 성공");
        }
        response.setBody(null);
        return response;
        }

}
