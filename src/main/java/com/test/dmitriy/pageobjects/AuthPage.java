package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final By createAnAccountEmailInput = By.id("email_create");
    private final By createAnAccountButton = By.id("SubmitCreate");
    private final By existingUserEmailInput = By.id("email");
    private final By existingUserPassword = By.id("passwd");

    private final By signInButton = By.id("SubmitLogin");

    public PersonalAccountPage signIn(String username, String password){
        $(existingUserEmailInput).sendKeys(username);
        $(existingUserPassword).sendKeys(password);
        $(signInButton).click();
        return new PersonalAccountPage();
    }
}
