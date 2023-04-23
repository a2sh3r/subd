package com.courses.subd.produser;

import com.courses.subd.dto.MeasurementClass;
import com.courses.subd.util.Measurement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, MeasurementClass> kafkaTemplate;

    public void send(MeasurementClass measurement){
        log.info("Payload: {}", measurement,toString());
        kafkaTemplate.send(topicName, measurement);
    }
}
