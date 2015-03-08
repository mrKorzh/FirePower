package com.springapp.services;

import com.springapp.firepower.FirePower;
import com.springapp.firepower.dao.FirePowerDaoImpl;
import com.springapp.services.controlcenter.ControlCenterClient;
import com.springapp.services.spacesituation.SpaceSituationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/FirePowerService")
public class FirePowerController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    FirePowerDaoImpl firePowerDao = (FirePowerDaoImpl)applicationContext.getBean("FirePowerDaoImpl");

    @Autowired
    private SpaceSituationClient spaceSituationClient;

    @RequestMapping(value = "/fromControlCenter")
    private void sendToSpaceSituation(HttpServletRequest request) {
        spaceSituationClient.sendToSpaceSituation("sddwfwefwefew");
    }

    @RequestMapping(value = "/getFirePowerList", method = RequestMethod.GET)
    @ResponseBody
    private String sendToControlCenter() {
        // возвращаем список огневых средств
        return firePowerDao.selectFirePowers().toString();
    }



    @RequestMapping(value = "/test")  // тестирование бд, потом удалить
    private void testDB(HttpServletRequest request) {
        FirePower firePower = new FirePower();
        firePower.setType(122321);
        firePower.setStateLongitude(543);
        firePower.setStateLatitude(435);
        firePower.setStateHeight(43534);
        firePower.setRangeMax(435);
        firePower.setRangeMin(345);
        firePower.setAzimutMax(34);
        firePower.setAzimutMin(435);
        firePower.setPlaceAngleMax(435);
        firePower.setPlaceAngleMin(345);
        firePower.setOperativnostMin(34534);
        firePower.setOperativnostMax(345);
        firePower.setChanceSuccessMin(34);
        firePower.setChanceSuccessMax(354);
        firePower.setChanceSuccessRatingResult(34);
        firePower.setChanceFalseAlarm(34);
        firePower.setCountInTime(34);
        firePowerDao.insertFirePower(firePower);
    }

}
