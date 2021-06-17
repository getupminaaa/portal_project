package com.example.kcalculator.controller;

import com.example.kcalculator.model.Food;
import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.User;
import com.example.kcalculator.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/food_record")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    @RequestMapping(value = "/insert_record")
    @ResponseBody
    ResponseEntity<?> insert(@ModelAttribute Food food, @ModelAttribute Record record ){
        return new ResponseEntity<>(foodService.insertFoodRecord(food,record), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/get_record")
    @ResponseBody
    ResponseEntity<?> get(@ModelAttribute Record record){
        return new ResponseEntity<>(foodService.getFoodRecord(record),HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "/update_record")
    @ResponseBody
    ResponseEntity<?> update(@ModelAttribute Food food ,@ModelAttribute Record record, @RequestParam String name){
        return new ResponseEntity<>(foodService.updateFoodRecord(food, record, name),HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete_record")
    @ResponseBody
    ResponseEntity<?> delete(@ModelAttribute Food food, @ModelAttribute Record record, @RequestParam String name){
        return new ResponseEntity<>(foodService.deleteFoodRecord(food,record,name),HttpStatus.OK);
    }

}
