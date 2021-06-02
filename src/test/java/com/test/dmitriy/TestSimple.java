package com.test.dmitriy;

import com.tngtech.jgiven.testng.ScenarioTest;
import org.testng.annotations.Test;

public class TestSimple extends ScenarioTest<Stages.Given, Stages.When, Stages.Then> {

    @Test
    public void test() {
        given()
                .signedInUser();
        when()
                .userBuysTshirt();
        then()
                .orderIsPlaced();
//        mainPage
//                .openTshirtsPage()
//                .addTshirtToTheCart()
//                .proceedToCheckoutPage()
//                .proceedToAddressPage()
//                .proceedToShippingPage()
//                .proceedToPayment()
//                .confirmOrder();
    }
}
