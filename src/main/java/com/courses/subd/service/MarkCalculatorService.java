package com.courses.subd.service;

import com.courses.subd.dao.CourseDao;
import com.courses.subd.dao.GroupDao;
import com.courses.subd.dao.StudentDao;
import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
import com.courses.subd.model.Student;
import com.courses.subd.repository.CourseRepository;
import com.courses.subd.repository.GroupRepository;
import com.courses.subd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkCalculatorService {
    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final GroupDao groupDao;
    @Autowired
    public MarkCalculatorService(StudentDao studentDao, CourseDao courseDao, GroupDao groupDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.groupDao = groupDao;
    }

    public Double CalculateMean(String courseName, String groupName){
        Long courseId = courseDao.findByName(courseName).getId();
        Long groupId = groupDao.findByName(groupName).getId();
        List<Student> students = studentDao.findByCourseAndGroup(courseId, groupId);
        return students.stream().map(Student::getMark).map(Integer::doubleValue)
                .reduce(0.0, Double::sum)/students.size();
    }

}
