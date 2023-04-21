package com.courses.subd.dao;

import com.courses.subd.model.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Course course = new Course();


        course.setCourseId(rs.getLong("courseId"));
        course.setName(rs.getString("NAME"));


        return course;
    }
}
