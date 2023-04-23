package com.courses.subd.repository;


import com.courses.subd.dto.MeasurementClass;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class MeasurementRepository {
    private final NamedParameterJdbcTemplate namedParameter;

    public void save(MeasurementClass measurementClass){
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id" ,measurementClass.getId())
                .addValue("currentA", measurementClass.getCurrentA())
                .addValue("currentB", measurementClass.getCurrentB())
                .addValue("currentC", measurementClass.getCurrentC());
        namedParameter.update("INSERT INTO measurement.test (id, currentA, currentB, currentC values (:id, :currentA, :currentB, :currentC);", param);
    }

    public class MeasurementClassMapper implements RowMapper<MeasurementClass> {
        @Override
        public MeasurementClass mapRow(ResultSet rs, int rowNum) throws SQLException{
            return new MeasurementClass(rs.getString("id"), rs.getDouble("currentA"),
                    rs.getDouble("currentB"), rs.getDouble("currentC"));
        }
    }

    public List<MeasurementClass> getAll() {
        return namedParameter.query("SELECT * FROM measurement.test", new MeasurementClassMapper());
    }
}
