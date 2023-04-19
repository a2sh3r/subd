package com.courses.subd.dao;

import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
import com.courses.subd.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Course course = new Course();


        course.setId(rs.getLong("ID"));
        course.setName(rs.getString("NAME"));
        course.setStudentId(rs.getObject("STUDENT_ID", ArrayList.class));


        return course;
    }
}
