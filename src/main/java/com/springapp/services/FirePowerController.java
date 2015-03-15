package com.springapp.services;

import com.springapp.firepower.FirePower;
import com.springapp.firepower.dao.FirePowerDaoImpl;
import com.springapp.jackson.PostEntityFromControlCenter;
import com.springapp.services.controlcenter.ControlCenterClient;
import com.springapp.services.spacesituation.SpaceSituationClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/FirePowerService")
public class FirePowerController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    FirePowerDaoImpl firePowerDao = (FirePowerDaoImpl)applicationContext.getBean("FirePowerDaoImpl");

    @Autowired
    private SpaceSituationClient spaceSituationClient;

    @Autowired
    private ControlCenterClient controlCenterClient;

    @RequestMapping(value = "/fromControlCenter")
    private void sendToSpaceSituation(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<PostEntityFromControlCenter> list = mapper.readValue(request.getReader().readLine(),
                new TypeReference<List<PostEntityFromControlCenter>>() {
                });
        PostEntityFromControlCenter postEntityFromControlCenter = list.get(0);
        String radialDistance = postEntityFromControlCenter.getRadial_distance();
        String polarAngle = postEntityFromControlCenter.getPolar_angle();
        String azimuthAngle = postEntityFromControlCenter.getAzimuth_angle();
        String number = postEntityFromControlCenter.getNumber();

        // получили firepower для выстрела
        FirePower firePowerForShort = firePowerDao.getFirePowerByNumber(Integer.valueOf(number));
        Double latitude = firePowerForShort.getStateLatitude();
        Double longitude = firePowerForShort.getStateLongitude();
        String jsonToSpaceSituationFirePower =
                "{\"latitude\": \"" + latitude + "\", " +
                        "\"longitude\": \"" + longitude + "\", " +
                        "}";

        String jsonToSpaceSituationTarget =
                "{\"radial_distance\": \"" + radialDistance + "\", " +
                "\"polar_angle\": \"" + polarAngle + "\", " +
                "\"azimut_angle\": \"" + azimuthAngle + "\"" +
                "}";
        spaceSituationClient.sendToSpaceSituation(jsonToSpaceSituationTarget, jsonToSpaceSituationFirePower);

        // шлем на центр контроля сообщение что выстрелили
        controlCenterClient.sendToControlCenter("Success");
    }

    @RequestMapping(value = "/getFirePowerList", method = RequestMethod.GET)
    @ResponseBody
    private String sendToControlCenter() {
        // возвращаем список огневых средств
        String firePowersList = firePowerDao.selectFirePowers().toString();
        return firePowersList;
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
