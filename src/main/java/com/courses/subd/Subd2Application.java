package com.courses.subd;

import com.courses.subd.model.CourseEm;
import com.courses.subd.model.GroupEm;
import com.courses.subd.model.StudentEm;
import com.courses.subd.repository.CourseEntityRepositoryImpl;
import com.courses.subd.repository.GroupEntityRepositoryImpl;
import com.courses.subd.repository.StudentEntityRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Subd2Application {

	private final StudentEntityRepositoryImpl studentEntityRepository;

	private  final GroupEntityRepositoryImpl groupEntityRepository;

	private final CourseEntityRepositoryImpl courseEntityRepository;

	public Subd2Application(StudentEntityRepositoryImpl studentEntityRepository, GroupEntityRepositoryImpl groupEntityRepository, CourseEntityRepositoryImpl courseEntityRepository) {
		this.studentEntityRepository = studentEntityRepository;
		this.groupEntityRepository = groupEntityRepository;
		this.courseEntityRepository = courseEntityRepository;
	}


	public static void main(String[] args) throws Exception{
		ApplicationContext context = SpringApplication.run(Subd2Application.class);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() throws Exception {
		GroupEm group = new GroupEm();
		group.setName("A");
		groupEntityRepository.add(group);

		CourseEm course = new CourseEm();
		course.setName("Math");
		courseEntityRepository.add(course);

		List<CourseEm> courseList = Arrays.asList(course);

		StudentEm student1  = new StudentEm();
		student1.setLastName("Zainut");
		student1.setFirstName("Misha");
		student1.setBatyaName("Marsich");
		student1.setGroup(group);
		student1.setCourses(courseList);
		student1.setMark(3);
		studentEntityRepository.add(student1);

		StudentEm student2  = new StudentEm();
		student2.setLastName("Zainut");
		student2.setFirstName("Misha");
		student2.setBatyaName("Marsich");
		student2.setGroup(group);
		student2.setCourses(courseList);
		student2.setMark(5);
		studentEntityRepository.add(student2);

		StudentEm student3  = new StudentEm();
		student3.setLastName("Zainut");
		student3.setFirstName("Misha");
		student3.setBatyaName("Marsich");
		student3.setGroup(group);
		student3.setCourses(courseList);
		student3.setMark(3);
		studentEntityRepository.add(student3);

		System.out.println(studentEntityRepository.calculateAverageMark(course, group));
	}


}
