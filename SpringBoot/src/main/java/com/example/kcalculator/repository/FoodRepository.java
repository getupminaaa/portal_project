package com.example.kcalculator.repository;

import com.example.kcalculator.model.Food;
import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Integer> {
    List<Food>findAllByRecord(Record record);
    Optional<Food>findByRecordAndAndName(Record record, String name);
}
