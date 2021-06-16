package com.example.kcalculator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String name;
    private Integer age;
    private Integer gender;
    private Float height;
    private Float weight;

    @JsonIgnore
    @Column(unique = true)
    private String token;
}