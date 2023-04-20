package com.courses.subd;

import com.courses.subd.dao.CourseDao;
import com.courses.subd.dao.GroupDao;
import com.courses.subd.dao.StudentDao;
import com.courses.subd.model.Student;
import com.courses.subd.service.MarkCalculatorService;
import org.h2.tools.Console;
import org.slf4j.IMarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@SpringBootApplication
public class SubdApplication {
	@Autowired
	MarkCalculatorService markCalculatorService;

	public static void main(String[] args) throws Exception{
		ApplicationContext context = SpringApplication.run(SubdApplication.class);

		CourseDao courseDao = context.getBean(CourseDao.class);
		GroupDao groupDao = context.getBean(GroupDao.class);
		StudentDao studentDao = context.getBean(StudentDao.class);

		


		Console.main(args);
	}

}
