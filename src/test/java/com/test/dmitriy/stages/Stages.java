package com.test.dmitriy.stages;

import com.test.dmitriy.pageobjects.MainPage;
import com.test.dmitriy.pageobjects.OrderConfirmationPage;
import com.test.dmitriy.pageobjects.PersonalInformationPage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.*;

public class Stages extends BaseTest {

    @ProvidedScenarioState
    static MainPage mainPage = new MainPage(baseUrl);

    @ProvidedScenarioState
    static OrderConfirmationPage orderConfirmationPage;

    @ProvidedScenarioState
    static String orderReference;

    @ProvidedScenarioState
    static String newFirstName = RandomStringUtils.randomAlphabetic(9);

    @ProvidedScenarioState
    static PersonalInformationPage personalInformationPage;

    @ProvidedScenarioState
    static String password = "randompassword";

    @ProvidedScenarioState
    static String email = "randomemail14@gmail.com";

    @BeforeTest
    public void openMainPage() {
        mainPage
                .openMainPage();
    }

    public static class Given extends Stage<Given> {

        public Given signedInCustomer() {
            mainPage
                    .openSignInPage()
                    .signIn(email, password)
                    .goToMainPage();
            return self();
        }
    }

    public static class When extends Stage<When> {

        public When customerBuysTshirt() {
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

        public When customerModifiesName() {
            personalInformationPage = mainPage
                    .goToPersonalAccountPage()
                    .proceedToPersonalInfoPage()
                    .modifyFirstName(newFirstName)
                    .enterPassword(password)
                    .saveNewPersonalInformation();
            return self();
        }
    }

    public static class Then extends Stage<Then> {

        public Then orderIsPesentInOrderHistory() {
            orderConfirmationPage
                    .proceedToOrdersHistoryPage()
                    .findTheOrderByReference(orderReference)
                    .logOut();
            return self();
        }

        public Then firstNameIsUpdated() {
            personalInformationPage
                    .successMessageAppears()
                    .userFirstNameIsUpdated(newFirstName)
                    .logOut();
            return self();
        }
    }

    @AfterClass
    public void closeWebDriver() {
        closeWebDriver();
    }
}
