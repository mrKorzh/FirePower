package com.springapp.firepower.dao;

import com.springapp.firepower.FirePower;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FirePowerRowMapper implements RowMapper<FirePower> {

    @Override
    public FirePower mapRow(ResultSet resultSet, int numRow) throws SQLException {
        FirePower firePower = new FirePower();
        firePower.setId(resultSet.getInt("id"));
        firePower.setType(resultSet.getInt("type"));
        firePower.setStateLongitude(resultSet.getDouble("stateLongitude"));
        firePower.setStateLatitude(resultSet.getDouble("stateLatitude"));
        firePower.setStateHeight(resultSet.getDouble("stateHeight"));
        firePower.setRangeMax(resultSet.getDouble("rangeMax"));
        firePower.setRangeMin(resultSet.getDouble("rangeMin"));
        firePower.setAzimutMax(resultSet.getDouble("azimutMax"));
        firePower.setAzimutMin(resultSet.getDouble("azimutMin"));
        firePower.setPlaceAngleMax(resultSet.getDouble("placeAngleMax"));
        firePower.setPlaceAngleMin(resultSet.getDouble("placeAngleMin"));
        firePower.setOperativnostMin(resultSet.getDouble("operativnostMin"));
        firePower.setOperativnostMax(resultSet.getDouble("operativnostMax"));
        firePower.setChanceSuccessMin(resultSet.getDouble("chanceSuccessMin"));
        firePower.setChanceSuccessMax(resultSet.getDouble("chanceSuccessMax"));
        firePower.setChanceSuccessRatingResult(resultSet.getDouble("chanceSuccessRatingResult"));
        firePower.setChanceFalseAlarm(resultSet.getDouble("chanceFalseAlarm"));
        firePower.setCountInTime(resultSet.getInt("countInTime"));

        return firePower;
    }
}
