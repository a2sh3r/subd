package com.courses.subd.dao;

import com.courses.subd.model.Course;
import com.courses.subd.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GroupDao {
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

    public Group findByName(String name){
        final String query = "SELECT * FROM STUDENTGROUP WHERE NAME = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { name }, new GroupRowMapper());
    }

    public int getCountOfGroups() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENTGROUP", Integer.class);
    }

    public List<Group> getAllGroups() {
        return jdbcTemplate.query("SELECT * FROM STUDENTGROUP", new GroupRowMapper());
    }

    public int addGroup(Group group) {
        return jdbcTemplate.update("INSERT INTO STUDENTGROUP VALUES (?, ?)", group.getGroupId(),
                group.getName());
    }
}
