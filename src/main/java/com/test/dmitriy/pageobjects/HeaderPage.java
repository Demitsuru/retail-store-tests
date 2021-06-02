package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final By personalAccountButton = By.xpath("//a[@title='View my customer account']");
    private final By logOutButton = By.xpath("//a[@title='Log me out']");
    private final By signInButton = By.xpath("//a[@title='Log in to your customer account']");

    public PersonalAccountPage goToPersonalAccountPage() {
        $(personalAccountButton).click();
        return new PersonalAccountPage();
    }

    public MainPage logOut() {
        $(logOutButton).click();
        return new MainPage();
    }

    public AuthPage openSignInPage() {
        $(signInButton).click();
        return new AuthPage();
    }
}
