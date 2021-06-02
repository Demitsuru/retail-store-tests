package com.test.dmitriy.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeliveryAddressPage {
    private final By proceedToCheckoutButton = By.xpath("//div[@id='center_column']//span[contains(text(), 'Proceed to checkout')]");

    public ShippingPage proceedToShippingPage(){
        $(proceedToCheckoutButton).click();
        return new ShippingPage();
    }
}
