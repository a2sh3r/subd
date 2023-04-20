package com.courses.subd.dao;

import com.courses.subd.model.Course;
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
public class CourseDao {
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

    public Course findByName(String name){
        final String query = "SELECT * FROM COURSE WHERE NAME = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { name }, new CourseRowMapper());
    }

    public int getCountOfCourses() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM COURSE", Integer.class);
    }

    public List<Course> getAllCourses() {
        return jdbcTemplate.query("SELECT * FROM COURSE", new CourseRowMapper());
    }

    public int addCourse(Course course) {
        return jdbcTemplate.update("INSERT INTO COURSE VALUES (?, ?)", course.getCourseId(),
                course.getName());
    }


}
