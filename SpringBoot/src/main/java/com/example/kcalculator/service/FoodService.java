package com.example.kcalculator.service;

import com.example.kcalculator.model.Food;
import com.example.kcalculator.model.Response;
import com.example.kcalculator.repository.FoodRepository;
import com.example.kcalculator.repository.RecordRepository;
import org.springframework.stereotype.Service;
import com.example.kcalculator.model.Record;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final RecordRepository recordRepository;
    private final FoodRepository foodRepository;

    public FoodService(RecordRepository recordRepository, FoodRepository foodRepository) {
        this.recordRepository = recordRepository;
        this.foodRepository = foodRepository;
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
            foodRepository.save(food);
            response.setResultCode(0);
            response.setDesc("성공");
        }
        return response;
    }

    public Response getFoodRecord(Record record) {
        Response response = new Response();
        Integer record_id = record.getId();
        Optional<Record> findRecord = recordRepository.findById(record_id);
        if(findRecord.isEmpty()){
            response.setResultCode(-1);
            response.setDesc("record doesn't exist");
        }else{
            List<Food> foods =  foodRepository.findAllByRecord(findRecord.get());
            response.setResultCode(0);
            response.setDesc("성공");
            response.setBody(foods);
        }
        return response;
    }

    //R
    //U
    //D

}
