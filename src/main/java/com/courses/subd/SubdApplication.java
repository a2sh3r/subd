package com.courses.subd;

import com.courses.subd.dao.CourseDao;
import com.courses.subd.dao.GroupDao;
import com.courses.subd.dao.StudentDao;
import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
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

		StudentDao studentDao = context.getBean(StudentDao.class);
		CourseDao courseDao = context.getBean(CourseDao.class);
		GroupDao groupDao = context.getBean(GroupDao.class);

		MarkCalculatorService markCalculatorService = new MarkCalculatorService(studentDao, courseDao, groupDao);

		Group group = new Group(4L,"4th");
		Course course = new Course(4L, "Physics");
		Student student = new Student(6L, "Frolov", "Sashka", "Pavlovich", group, course, 4);

		System.out.println(student.getStudentGroup());

		courseDao.addCourse(course);
		groupDao.addGroup(group);
		studentDao.addStudent(student);


		System.out.println(studentDao.getAllStudents());
		System.out.println(studentDao.findByCourseAndGroup(3L, 1L));
		System.out.println("Средняя оценка по Доте в группе 1 - " + markCalculatorService.CalculateMean("CS", "1st"));

		Console.main(args);
	}

}
