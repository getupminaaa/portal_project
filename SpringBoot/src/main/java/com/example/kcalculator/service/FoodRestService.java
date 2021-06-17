package com.example.kcalculator.service;

import com.example.kcalculator.model.Food;
import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.Response;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class FoodRestService {
    public Response getRestFood (String desc_kor)  {
        Response response = new Response();

        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList");
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=uDr5c0t8AWGtzKwviPM39ACJlsqF690cmy6TpcnsAFFI3FnFPi%2FXl%2BAXzhgDqddLP98EEKaVjaw1NI%2BrqTnO8w%3D%3D");
            urlBuilder.append("&" + URLEncoder.encode("desc_kor","UTF-8") + "=" + URLEncoder.encode(desc_kor, "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String returnLine;
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            JSONObject jsonObject = XML.toJSONObject(result.toString());
            urlConnection.disconnect();
            response.setBody(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
/*    public String callApiWithJson(@RequestParam String desc_kor) {
        desc_kor = "바나나";
        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList"); *//*URL*//*
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=uDr5c0t8AWGtzKwviPM39ACJlsqF690cmy6TpcnsAFFI3FnFPi%2FXl%2BAXzhgDqddLP98EEKaVjaw1NI%2BrqTnO8w%3D%3D"); *//*Service Key*//*
            urlBuilder.append("&" + URLEncoder.encode("desc_kor","UTF-8") + "=" + URLEncoder.encode("바나나", "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String returnLine;
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            JSONObject jsonObject = XML.toJSONObject(result.toString());
            jsonPrintString = jsonObject.toString();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonPrintString;
    }*/