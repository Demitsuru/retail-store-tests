package com.test.dmitriy.stages;

import com.test.dmitriy.pageobjects.MainPage;
import com.test.dmitriy.pageobjects.OrderConfirmationPage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class Stages extends BaseTest {

    @ProvidedScenarioState
    static MainPage mainPage = new MainPage(baseUrl);

    @ProvidedScenarioState
    static OrderConfirmationPage orderConfirmationPage;

    @ProvidedScenarioState
    static String orderReference;

    public static class Given extends Stage<Given> {

        public Given signedInUser() {

            mainPage
                    .openMainPage()
                    .openSignInPage()
                    .signIn("randomemail14@gmail.com", "randompassword")
                    .goToMainPage();
            return self();
        }
    }

    public static class When extends Stage<When> {
        public When userBuysTshirt() {
            orderConfirmationPage = mainPage
                    .openTshirtsPage()
                    .addTshirtToTheCart()
                    .proceedToCheckoutPage()
                    .proceedToAddressPage()
                    .proceedToShippingPage()
                    .proceedToPayment()
                    .confirmOrder()
                    .confirmOrderAndCheckConfirmationText();
            orderReference = orderConfirmationPage.extractOrderReference().orElse("");
            return self();
        }
    }

    public static class Then extends Stage<Then> {
        public Then orderIsPlaced() {
            return self();
        }
    }
}
