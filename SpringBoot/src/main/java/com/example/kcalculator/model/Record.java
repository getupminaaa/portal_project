package com.example.kcalculator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "record")
@Table(name = "record", uniqueConstraints = @UniqueConstraint(columnNames = { "date", "category" }))
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Integer id;

    private Date date;
    private Integer category;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn (name="user_email", referencedColumnName = "email")
    @JsonIgnore
    private User user;

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
