package com.example.kcalculator.controller;

import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.User;
import com.example.kcalculator.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;


@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    //C
    @PostMapping
    @RequestMapping(value = "/insert")
    @ResponseBody
    ResponseEntity<?> insert(@ModelAttribute Record record,@ModelAttribute User user,@RequestParam Date date) {
        return new ResponseEntity<>(recordService.insert(record,user,date), HttpStatus.OK);
    }
    //R
    @GetMapping
    @RequestMapping(value = "/get_record")
    @ResponseBody
    ResponseEntity<?> getRecord(@ModelAttribute User user , @RequestParam Date date){
        return new ResponseEntity<>(recordService.getRecords(user,date),HttpStatus.OK);
    }
    //U
    @PostMapping
    @RequestMapping(value = "/update_record")
    @ResponseBody
    ResponseEntity<?> updateRecord(@ModelAttribute Record record,@ModelAttribute User user, @RequestParam Date date, @RequestParam Integer category) {
        return new ResponseEntity<>(recordService.updateRecord(record,user,date,category), HttpStatus.OK);
    }
    //D
    @DeleteMapping
    @RequestMapping(value = "/delete")
    @ResponseBody
    ResponseEntity<?> delete(@ModelAttribute User user, @RequestParam Date date, @RequestParam Integer category) {
        return new ResponseEntity<>(recordService.delete(user,date,category), HttpStatus.OK);
    }

}
