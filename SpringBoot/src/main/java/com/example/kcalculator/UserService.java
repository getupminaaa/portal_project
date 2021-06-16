package com.example.kcalculator;

import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import com.example.kcalculator.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response insert(User user){
        user.setToken(UUID.randomUUID().toString());
        userRepository.save(user);

        Response response = new Response();
        response.setResultCode(0);
        response.setBody("가입 성공");
        return  response;
    }

    public Response login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password).get();
        Response response = new Response();
        if (user != null) {
            response.setResultCode(0);
            response.setDesc("success");
        } else {
            response.setResultCode(-1);
            response.setDesc("fail");
        }
        return response;

    }

    public Response myInfo(String token) {
        Optional<User> user = userRepository.findByToken(token);
        Response response = new Response();
        if (user.isPresent()) {
            response.setResultCode(0);
            response.setDesc("success");
            response.setBody(user.get());
        } else {
            response.setResultCode(-1);
            response.setDesc("fail");
        }
        return response;
    }
}
