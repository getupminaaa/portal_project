package com.example.kcalculator.service;

import com.example.kcalculator.model.Food;
import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import com.example.kcalculator.repository.FoodRepsitory;
import com.example.kcalculator.repository.RecordRepository;
import org.springframework.stereotype.Service;
import com.example.kcalculator.model.Record;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final RecordRepository recordRepository;
    private final FoodRepsitory foodRepsitory;

    public FoodService(RecordRepository recordRepository, FoodRepsitory foodRepsitory) {
        this.recordRepository = recordRepository;
        this.foodRepsitory = foodRepsitory;
    }

    public Response insertFoodRecord(Food food,Record record) {
        Response response = new Response();
        Integer record_id = record.getId();
        Optional<Record> findRecord = recordRepository.findById(record_id);
        if(findRecord.isEmpty()){
            response.setResultCode(-1);
            response.setDesc("record doesn't exist");
        }else{
            food.setRecord(findRecord.get());
            foodRepsitory.save(food);
            response.setResultCode(0);
            response.setDesc("성공");
            response.setBody(food);

        }

//        if (findRecord.isEmpty()) {
//            response.setResultCode(-1);
//            response.setDesc("record가 없음");
//        }else{
//          \
//          food.setRecord(findRecord.get());
//
//            foodRepsitory.save(food);
//            response.setResultCode(0);
//            response.setDesc("성공입니다.");
//            response.setBody(food);
//        }
        return response;
    }

    public Response getFoodRecord() {
        Response response = new Response();
        return response;
    }


    //C

    //R
    //U
    //D

}
