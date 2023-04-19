package com.courses.subd;

import com.courses.subd.dao.CourseDao;
import com.courses.subd.dao.GroupDao;
import com.courses.subd.dao.StudentDao;
import com.courses.subd.model.Student;
import com.courses.subd.service.MarkCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SubdApplicationTests {

	@Autowired
	MarkCalculatorService markCalculatorService;
	@Autowired
	StudentDao studentDao;
	@Autowired
	GroupDao groupDao;
	@Autowired
	CourseDao courseDao;


	@Test
	void contextLoads() {
	}

//	@Test
//	void MarkCalculatorTest(){
//		System.out.println(markCalculatorService.CalculateMean("Math", "1st"));
//	}

}
