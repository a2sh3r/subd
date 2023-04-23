package com.courses.subd.controller;

import com.courses.subd.dto.MeasurementClass;
import com.courses.subd.dto.TimeStamp;
import com.courses.subd.repository.MeasurementRepository;
import com.courses.subd.util.Measurement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.courses.subd.produser.TopicProducer;

import java.sql.Time;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
@RestController
public class KafkaController {
    
    private final TopicProducer topicProducer;
    private final MeasurementClass measurementClass;
    private final TimeStamp timeStamp;
    private final MeasurementRepository measurementRepository;
    
    @PostMapping(value = "/send")
    public void send(@RequestParam(name = "measurement") MeasurementClass measurementClass){
        topicProducer.send(measurementClass);
    }

    @GetMapping("/get")
    public List<MeasurementClass> get(){
        return measurementRepository.getAll();
    }

}
