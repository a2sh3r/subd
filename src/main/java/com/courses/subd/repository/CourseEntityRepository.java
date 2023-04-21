package com.courses.subd.repository;

import com.courses.subd.model.CourseEm;

public interface CourseEntityRepository{

    void add(CourseEm course);
    void update(CourseEm course);
    void delete(CourseEm course);
    CourseEm findCourseById(int id);
    CourseEm findByName(String name);
}
