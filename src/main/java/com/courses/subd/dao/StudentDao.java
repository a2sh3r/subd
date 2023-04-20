package com.courses.subd.dao;

import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
import com.courses.subd.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDao {
    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("STUDENTS");

    }

    public int getCountOfStudents() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENTS", Integer.class);
    }

    public List<Student> getAllStudents() {
        return jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());
    }

    public int addStudent(Student student) {
        return jdbcTemplate.update("INSERT INTO STUDENTS VALUES (?, ?, ?, ?, ?, ?, ?)", student.getId(),
                student.getSecondName(), student.getFirstName(), student.getBatyaName(), student.getStudentGroup(),
                student.getCourses(), student.getMark());
    }

    public List<Student> findByCourseAndGroup(Long courseId, Long groupId){
        return namedParameterJdbcTemplate.queryForList(
                "SELECT * FROM STUDENTS WHERE COURSE_ID = :courseId AND GROUP_ID = :groupId",
                new MapSqlParameterSource()
                        .addValue("courseId", courseId)
                        .addValue("groupId", groupId), Student.class);
    }


}
