package com.example.kcalculator.controller;

import com.example.kcalculator.service.FoodRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restfood")
@RequiredArgsConstructor
public class FoodRestController {

    private final FoodRestService foodRestService;

    @GetMapping("/request/foodInfo")
    @ResponseBody
    public ResponseEntity<?>getRestFood(@RequestParam String desc_kor){
        return new ResponseEntity<>(foodRestService.getRestFood(desc_kor), HttpStatus.OK);
    }
}