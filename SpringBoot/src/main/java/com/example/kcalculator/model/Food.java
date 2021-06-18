package com.example.kcalculator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.stream.events.StartDocument;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String name;
    private Float intake;
    private String file_name;
    private String file_path;

    @ManyToOne(targetEntity = Record.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    public Record record;
}
