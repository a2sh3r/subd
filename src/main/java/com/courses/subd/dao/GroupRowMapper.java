package com.courses.subd.dao;

import com.courses.subd.model.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupRowMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Group group = new Group();

        group.setGroupId(rs.getLong("groupId"));
        group.setName(rs.getString("NAME"));


        return group;
    }
}
