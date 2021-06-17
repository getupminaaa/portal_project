package com.example.kcalculator.service;

import com.example.kcalculator.model.Record;
import com.example.kcalculator.model.Response;
import com.example.kcalculator.model.User;
import com.example.kcalculator.repository.RecordRepository;
import com.example.kcalculator.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public RecordService(RecordRepository recordRepository, UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
    }

    public Response insert(Record record, User user ,Date date) {
        Response response = new Response();
        String userEmail = user.getEmail();
        Optional<User> findUser = userRepository.findByEmail(userEmail);
        if (findUser.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("존재하지않는 사용자입니다.");
        } else {
            record.setDate(date);
            record.setUser(findUser.get());
            recordRepository.save(record);
            response.setResultCode(0);
            response.setDesc("insert 성공");
        }
        return response;
    }

    public Response getRecords(User user, Date date) {
        Response response = new Response();
        String userEmail = user.getEmail();
        Optional<User> findUser = userRepository.findByEmail(userEmail);
        if (findUser.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("존재하지않는 사용자입니다.");
        } else {
            List<Record> record = recordRepository.findAllByUserAndDate(findUser.get(), date);
            if (record.isEmpty()) {
                response.setResultCode(-1);
                response.setDesc("존재하지않는 글입니다.");
            } else {
                response.setResultCode(0);
                response.setDesc("성공");
                response.setBody(record);
            }
        }
        return response;
    }


    public Response delete( User user, Date date, Integer category) {
        Response response = new Response();
        String userEmail = user.getEmail();
        Optional<User> findUser = userRepository.findByEmail(userEmail);
        if (findUser.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("존재하지않는 사용자입니다.");
        } else {
            Optional<Record> beforeRecord = recordRepository.findByUserAndDateAndCategory(findUser.get(), date, category);
            if (beforeRecord.isEmpty()) {
                response.setResultCode(-1);
                response.setDesc("존재하지않는 글입니다.");
            } else {
                recordRepository.delete(beforeRecord.get());
                response.setResultCode(0);
                response.setDesc("성공");
            }
        }
        return response;
    }

    public Response updateRecord(Record record, User user, Date date, Integer category) {
        Response response = new Response();
        String userEmail = user.getEmail();
        Optional<User> findUser = userRepository.findByEmail(userEmail);
        if (findUser.isEmpty()) {
            response.setResultCode(-1);
            response.setDesc("존재하지않는 사용자입니다.");
        } else {
            Optional<Record> beforeRecord = recordRepository.findByUserAndDateAndCategory(findUser.get(), date, category);
            if (beforeRecord.isEmpty()) {
                response.setResultCode(-1);
                response.setDesc("존재하지않는 글입니다.");
            } else {
                record.setId(beforeRecord.get().getId());
                record.setUser(findUser.get());
                record.setDate(beforeRecord.get().getDate());
                recordRepository.save(record);
                response.setResultCode(0);
                response.setDesc("성공");
            }
        }
        return response;
    }
}
