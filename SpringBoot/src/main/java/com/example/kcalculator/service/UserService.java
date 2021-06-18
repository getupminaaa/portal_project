package com.example.kcalculator.service;

import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import com.example.kcalculator.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response insert(User user) {
        Response response = new Response();
        Optional <User> existUser = userRepository.findByEmail(user.getEmail());
        if(existUser.isEmpty()){
            user.setToken(UUID.randomUUID().toString());
            userRepository.save(user);
            response.setResultCode(0);
            response.setBody("가입 성공");
        }else{
            response.setResultCode(-1);
            response.setDesc("이미 존재하는 사용자입니다.");
        }
        return response;
    }

    public Response login(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        Response response = new Response();
        if (user.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("fail");
        } else {
            response.setResultCode(0);
            response.setDesc("success");
        }
        return response;
    }

    public Response deleteUser(String token) {
        Optional<User> user = userRepository.findByToken(token);
        Response response = new Response();
        if (user.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("이미 삭제된 사용자입니다. ");
        }else{
            userRepository.delete(user.get());
            response.setResultCode(0);
            response.setDesc("삭제 성공");
        }
        return response;
    }

    public Response getUserInfo(String token) {
        Optional<User> user = userRepository.findByToken(token);
        Response response = new Response();
        if (user.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("fail");
        } else {
            response.setResultCode(0);
            response.setDesc("success");
            response.setBody(user.get());
        }
        return response;
    }
    public Response updateUserInfo(User user, String token){
        Optional<User> beforeUser = userRepository.findByToken(token);
        Response response = new Response();
        if(beforeUser.isEmpty()){
            response.setResultCode(-1);
            response.setDesc("없는 사용자입니다");
        }
        else {
            user.setId(beforeUser.get().getId());
            user.setEmail(beforeUser.get().getEmail());
            user.setPassword(beforeUser.get().getPassword());
            user.setToken(beforeUser.get().getToken());
            userRepository.save(user);
            response.setResultCode(0);
            response.setDesc("성공");
        }
        return  response;
    }
}
