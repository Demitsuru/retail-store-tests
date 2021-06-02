package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInformationPage extends HeaderPage {

    private final By firstNameInputField = By.xpath("//input[@id='firstname']");
    private final By saveButton = By.xpath("//span[contains(text(),'Save')]");
    private final By currentPassword = By.xpath("//input[@id='old_passwd']");
    private final By successMessage = By.xpath("//p[contains(text(),'Your personal information has been successfully updated.')]");
    private final By myAccountBreadCrumb = By.xpath("//div/a[contains(text(),'My account')]");

    public PersonalInformationPage modifyFirstName(String newFirstName) {
        $(firstNameInputField).clear();
        $(firstNameInputField).sendKeys(newFirstName);
        return new PersonalInformationPage();
    }

    public PersonalInformationPage enterPassword(String password) {
        $(currentPassword).clear();
        $(currentPassword).sendKeys(password);
        return new PersonalInformationPage();
    }

    public PersonalInformationPage saveNewPersonalInformation() {
        $(saveButton).click();
        return new PersonalInformationPage();
    }

    public PersonalInformationPage successMessageAppears() {
        $(successMessage).shouldBe(visible);
        $(myAccountBreadCrumb).click();
        return new PersonalInformationPage();
    }

    public PersonalInformationPage userFirstNameIsUpdated(String newFirstName) {
        $(withText(toProcessedString(newFirstName))).shouldBe(visible);
        return new PersonalInformationPage();
    }

    private String toProcessedString(String firstName) {
        String firstLetter = firstName.substring(0,0).toUpperCase();
        String remainingLetters = firstName.substring(1).toLowerCase();
        return firstLetter + remainingLetters;
    }
}
