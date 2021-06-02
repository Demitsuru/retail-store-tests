package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {
    private final By orderHistory = By.xpath("//span[contains(text(),'Order history and details')]");
    private final By personalInformation = By.xpath("//span[contains(text(),'My personal information')]");
    private final By logo = By.xpath("//img[@alt='My Store']");

    public MainPage goToMainPage() {
        $(logo).click();
        return new MainPage();
    }

    public PersonalInformationPage proceedToPersonalInfoPage() {
        $(personalInformation).click();
        return new PersonalInformationPage();
    }
}
