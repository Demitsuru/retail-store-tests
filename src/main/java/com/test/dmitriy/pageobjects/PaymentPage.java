package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private By payByBankWireButton = By.xpath("//a[@title='Pay by bank wire']");

    public OrderConfirmationPage confirmOrder(){
        $(payByBankWireButton).click();
        return new OrderConfirmationPage();
    }
}
