package com.test.dmitriy.scenarios;

import com.test.dmitriy.stages.Stages;
import com.tngtech.jgiven.testng.ScenarioTest;
import org.testng.annotations.Test;

public class BuyTshirtScenario extends ScenarioTest<Stages.Given, Stages.When, Stages.Then> {

    @Test
    public void test() {
        given()
                .signedInUser();
        when()
                .userBuysTshirt();
        then()
                .orderIsPlaced();
    }
}
