package com.example.kcalculator.repository;

import com.example.kcalculator.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepsitory extends JpaRepository<Food,Integer> {

}
