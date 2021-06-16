package com.example.kcalculator.repository;

import com.example.kcalculator.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Integer> {
}
