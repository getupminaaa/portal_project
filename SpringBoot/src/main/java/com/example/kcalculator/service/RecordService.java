package com.example.kcalculator.service;

import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import com.example.kcalculator.repository.RecordRepository;
import com.example.kcalculator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public RecordService(RecordRepository recordRepository, UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
    }

    public Response insert(Record record) {
        Response response = new Response();
        Optional<User> user = userRepository.findByEmail(record.getEmail());
        if (user.isEmpty()) {
            response.setResultCode(-1);
            response.setBody("앖는 사용자입니다.");
        } else {
            record.setDate(LocalDateTime.now());
            recordRepository.save(record);
            response.setResultCode(0);
            response.setDesc("insert 성공");
        }
        return response;
    }

    public Response getRecord(Integer id) {
        Response response = new Response();
        Optional<Record> record = recordRepository.findById(id);
        if (record.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("존재하지않는 글입니다.");
        } else {
            response.setResultCode(0);
            response.setDesc("성공");
            response.setBody(record.get());
        }
        return response;
    }

    public Response delete(Integer id) {
        Optional<Record> record = recordRepository.findById(id);
        Response response = new Response();
        if (record.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("이미 삭제된 글입니다.");
        } else {
            recordRepository.delete(record.get());
            response.setResultCode(0);
            response.setDesc("삭제 성공");
        }
        return response;
    }

    public Response updateRecord(Record record, Integer id) {
        Optional<Record> beforeRecord = recordRepository.findById(id);
        Response response = new Response();
        if (beforeRecord.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("존재하지않는 글입니다.");
        }else{
            record.setId(beforeRecord.get().getId());
            record.setDate(LocalDateTime.now());
            recordRepository.save(record);
            response.setResultCode(0);
            response.setDesc("성공");
        }

        return response;
    }
}
