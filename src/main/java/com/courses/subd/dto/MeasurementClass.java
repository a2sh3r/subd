package com.courses.subd.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementClass {

    private String id;
    private Double currentA;
    private Double currentB;
    private Double currentC;
}
