package com.example.kcalculator.controller;

import com.example.kcalculator.model.Record;
import com.example.kcalculator.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    //C
    @PostMapping
    @RequestMapping(value = "/insert")
    @ResponseBody
    ResponseEntity<?> insert(@ModelAttribute Record record) {
        return new ResponseEntity<>(recordService.insert(record), HttpStatus.OK);
    }
    //R
    @GetMapping
    @RequestMapping(value = "/get_record")
    @ResponseBody
    ResponseEntity<?> getRecord(@RequestParam Integer id){
        return new ResponseEntity<>(recordService.getRecord(id),HttpStatus.OK);
    }
    //U
    @PostMapping
    @RequestMapping(value = "/update_record")
    @ResponseBody
    ResponseEntity<?> updateRecord(@ModelAttribute Record record, @RequestParam Integer id) {
        return new ResponseEntity<>(recordService.updateRecord(record,id), HttpStatus.OK);
    }
    //D
    @DeleteMapping
    @RequestMapping(value = "/delete")
    @ResponseBody
    ResponseEntity<?> delete(@RequestParam Integer id) {
        return new ResponseEntity<>(recordService.delete(id), HttpStatus.OK);
    }

}
