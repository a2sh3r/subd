package com.courses.subd.dao;

import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
import com.courses.subd.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Student student = new Student();

        final Group group = new Group();
        group.setGroupId(rs.getLong("GROUP_ID"));

        final Course course = new Course();
        course.setCourseId(rs.getLong("COURSE_ID"));



        student.setId(rs.getLong("ID"));
        student.setSecondName(rs.getString("SECOND_NAME"));
        student.setFirstName(rs.getString("FIRST_NAME"));
        student.setBatyaName(rs.getString("BATYA_NAME"));
        student.setStudentGroup(group);
        student.setCourses(rs.getObject("COURSE_ID", Course.class));
        student.setMark(rs.getInt("MARK"));


        return student;
    }
}
