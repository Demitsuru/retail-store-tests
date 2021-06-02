package com.test.dmitriy.scenarios;

import com.test.dmitriy.stages.Stages;
import com.tngtech.jgiven.testng.ScenarioTest;
import org.testng.annotations.Test;

public class BuyTshirtScenario extends ScenarioTest<Stages.Given, Stages.When, Stages.Then> {

    @Test
    public void customerIsAbleToBuyATshirt() {
        given().signedInCustomer();
        when().customerBuysTshirt();
        then().orderIsPesentInOrderHistory();
    }

    @Test
    public void customerIsAbleToModifyFirstName() {
        given().signedInCustomer();
        when().customerModifiesName();
        then().firstNameIsUpdated();
    }
}
