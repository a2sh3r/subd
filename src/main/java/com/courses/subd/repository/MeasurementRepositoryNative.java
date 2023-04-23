package com.courses.subd.repository;

import com.clickhouse.jdbc.ClickHouseConnection;
import com.clickhouse.jdbc.ClickHouseDataSource;
import com.clickhouse.jdbc.ClickHouseStatement;
import com.courses.subd.dto.MeasurementClass;
import com.courses.subd.dto.MeasurementClassNative;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Component
@AllArgsConstructor
public class MeasurementRepositoryNative {
    private final ClickHouseDataSource clickHouseDataSource;

    public void save(MeasurementClassNative measurement) {
        try (ClickHouseConnection clickHouseConnection =
                     clickHouseDataSource.getConnection()) {

            clickHouseConnection.getTransaction();
            PreparedStatement preparedStatement =
                    clickHouseConnection.prepareStatement("insert into measurement.test (id, currentA, currentB, currentC) " +
                            "SETTINGS async_insert=1, wait_for_async_insert=0 " +
                            "values (?, ?, ?, ?);");
            preparedStatement.setString(1, measurement.id());
            preparedStatement.setDouble(3, measurement.currentA());
            preparedStatement.setDouble(3, measurement.currentB());
            preparedStatement.setDouble(4, measurement.currentC());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MeasurementClass> findAll() {
        try {
            ClickHouseStatement statement = clickHouseDataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from measurement.test");
            List<MeasurementClass> measurements = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                double currentA = resultSet.getDouble("currentA");
                double currentB = resultSet.getDouble("currentB()");
                double currentC = resultSet.getDouble("currentC()");
                measurements.add(new MeasurementClass(id, currentA, currentB, currentC));
            }
            return measurements;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
