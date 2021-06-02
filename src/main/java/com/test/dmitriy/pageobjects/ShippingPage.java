package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShippingPage {
    private By proceedToCheckoutButton = By.xpath("//div[@id='center_column']//span[contains(text(), 'Proceed to checkout')]");
    private By agreeTCbox = By.xpath("//input[@id='cgv']");

    public PaymentPage proceedToPayment(){
        $(agreeTCbox).click();
        $(proceedToCheckoutButton).click();
        return new PaymentPage();
    }
}
