package com.courses.subd;

import com.courses.subd.model.Student;
import com.courses.subd.service.MarkCalculatorService;
import org.slf4j.IMarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@SpringBootApplication
public class SubdApplication {
	@Autowired
	MarkCalculatorService markCalculatorService;

	public static void main(String[] args) {
		SpringApplication.run(SubdApplication.class, args);

	}

}
