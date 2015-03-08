package com.springapp.firepower.dao;

import com.springapp.firepower.FirePower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FirePowerDaoImpl implements FirePowerDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertFirePower(FirePower firePower) {
        String sql = "insert into firepowers (type, stateLongitude, stateLatitude, stateHeight, rangeMax, rangeMin, " +
                "azimutMax, azimutMin, placeAngleMax, placeAngleMin, operativnostMin, operativnostMax, chanceSuccessMin, " +
                "chanceSuccessMax, chanceSuccessRatingResult, chanceFalseAlarm, countInTime) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                firePower.getType(),
                firePower.getStateLongitude(),
                firePower.getStateLatitude(),
                firePower.getStateHeight(),
                firePower.getRangeMax(),
                firePower.getRangeMin(),
                firePower.getAzimutMax(),
                firePower.getAzimutMin(),
                firePower.getPlaceAngleMax(),
                firePower.getPlaceAngleMin(),
                firePower.getOperativnostMin(),
                firePower.getOperativnostMax(),
                firePower.getChanceSuccessMin(),
                firePower.getChanceSuccessMax(),
                firePower.getChanceSuccessRatingResult(),
                firePower.getChanceFalseAlarm(),
                firePower.getCountInTime());

        System.out.println("Created record: "
                + "type = " + firePower.getType()
                + "stateLongitude = " + firePower.getStateLongitude()
                + "stateLatitude = " + firePower.getStateLatitude()
                + "stateHeight = " + firePower.getStateHeight()
                + "rangeMax = " + firePower.getRangeMax()
                + "rangeMin = " + firePower.getRangeMin()
                + "azimutMax = " + firePower.getAzimutMax()
                + "azimutMin = " + firePower.getAzimutMin()
                + "placeAngleMax = " + firePower.getPlaceAngleMax()
                + "placeAngleMin = " + firePower.getPlaceAngleMin()
                + "operativnostMin = " + firePower.getOperativnostMin()
                + "operativnostMax = " + firePower.getOperativnostMax()
                + "chanceSuccessMin = " + firePower.getChanceSuccessMin()
                + "chanceSuccessMax = " + firePower.getChanceSuccessMax()
                + "chanceSuccessRatingResult = " + firePower.getChanceSuccessRatingResult()
                + "chanceFalseAlarm = " + firePower.getChanceFalseAlarm()
                + "countInTime = " + firePower.getCountInTime());
    }
}
