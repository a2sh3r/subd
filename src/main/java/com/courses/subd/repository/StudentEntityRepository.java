package com.courses.subd.repository;

import com.courses.subd.model.CourseEm;
import com.courses.subd.model.GroupEm;
import com.courses.subd.model.StudentEm;

import java.util.List;

public interface StudentEntityRepository{

    void add(StudentEm student);
    void update(StudentEm student);
    void delete(StudentEm student);
    StudentEm findStudentById(int id);
    List<StudentEm> findStudentByGroupAndCourse(CourseEm course, GroupEm group);
    double calculateAverageMark(CourseEm course, GroupEm group);

}
