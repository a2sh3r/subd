package com.courses.subd.dao;

import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
import com.courses.subd.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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
        GroupDao groupDao = new GroupDao();
        final String query = "SELECT * FROM STUDENTGROUP WHERE NAME = ?";
        if (jdbcTemplate.queryForObject(query, new Object[] { student.getStudentGroup().getName() }, new GroupRowMapper()) == null){
            groupDao.addGroup(student.getStudentGroup());
        }
        return namedParameterJdbcTemplate.update(
                "INSERT INTO STUDENTS (ID, SECOND_NAME, FIRST_NAME, BATYA_NAME, studentGroup, courses, MARK) VALUES (:id, :second_name, :first_name, :batya_name, :studentGroup, :courses, :mark)",
                new MapSqlParameterSource()
                        .addValue("id", student.getId())
                        .addValue("second_name", student.getSecondName())
                        .addValue("first_name", student.getFirstName())
                        .addValue("batya_name", student.getBatyaName())
                        .addValue("studentGroup", student.getStudentGroup().getGroupId())
                        .addValue("courses", student.getCourses().getCourseId())
                        .addValue("mark", student.getMark()));

    }

    public List<Integer> findByCourseAndGroup(Long courseId, Long groupId){
        return namedParameterJdbcTemplate.queryForList(
                "SELECT MARK FROM STUDENTS WHERE courses = :courseId AND studentGroup = :groupId",
                new MapSqlParameterSource()
                        .addValue("courseId", courseId)
                        .addValue("groupId", groupId), Integer.class);
    }


}
