package com.example.kcalculator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;

    private String name;
    private Integer age;
    private Integer gender;
    private Float height;
    private Float weight;

    @JsonIgnore
    private String token;
}