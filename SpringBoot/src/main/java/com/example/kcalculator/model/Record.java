package com.example.kcalculator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Integer id;
    private LocalDateTime date;

    private Integer category;
    private String email;
    private String context;
    private Float total_kcal;
    private Float total_carbohydrate;
    private Float total_protein;
    private Float total_fat;
    private Float total_sugars;
    private Float total_natrium;
    private Float total_cholesterol;
    private Float total_fatty_acid;
    private Float total_trans_fatty_acid;
}
