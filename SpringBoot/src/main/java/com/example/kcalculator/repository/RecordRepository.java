package com.example.kcalculator.repository;

import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface RecordRepository extends JpaRepository<Record,Integer> {
    List<Record> findAllByUserAndDate(User user, Date date);
    Optional<Record> findByUserAndDateAndCategory(User user, Date date, Integer category);
}
