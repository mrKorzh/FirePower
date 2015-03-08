package com.springapp.firepower.dao;


import com.springapp.firepower.FirePower;

import java.util.List;

public interface FirePowerDao {

    void insertFirePower(FirePower firePower);

    List<FirePower> selectFirePowers();

}
