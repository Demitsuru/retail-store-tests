package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private final By proceedToCheckoutButton = By.xpath("//div[@id='center_column']//span[contains(text(), 'Proceed to checkout')]");

    public DeliveryAddressPage proceedToAddressPage(){
        $(proceedToCheckoutButton).click();
        return new DeliveryAddressPage();
    }
}
