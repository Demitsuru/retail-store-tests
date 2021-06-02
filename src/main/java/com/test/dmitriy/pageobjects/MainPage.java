package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends HeaderPage {

    private String baseUrl;
    private final By signIn = By.className("login");
    private final By tShirts = By.xpath("//ul[contains(@class,'menu-content')]/li/a[@title='T-shirts']");

    public MainPage() {
    }

    public MainPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public MainPage openMainPage() {
        open(this.baseUrl);
        return new MainPage();
    }

    public AuthPage openSignInPage() {
        $(signIn).click();
        return new AuthPage();
    }

    public TshirtsPage openTshirtsPage() {
        $(tShirts).click();
        return new TshirtsPage();
    }
}
