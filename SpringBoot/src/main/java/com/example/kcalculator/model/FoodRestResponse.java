package com.example.kcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodRestResponse {
    private Integer resultCode;
    private String resultMsg;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;
    private String desc_kor;
    private Float once_provide;
    private Float once_kcal;
    private Float once_carbohydrate;
    private Float once_protein;
    private Float once_fat;
    private Float once_sugars;
    private Float once_natrium;
    private Float once_cholesterol;
    private Float once_fatty_acid;
    private Float once_trans_fatty_acid;

}
